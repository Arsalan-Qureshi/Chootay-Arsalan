package com.chootay.salesservice.services;

import com.chootay.salesservice.models.Sales;
import com.chootay.salesservice.models.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SalesRepository salesRepository;

    public SalesService() {
    }

    public List<Sales> generateDailyReport(String token, String date) {
        if (authenticateSalesperson(token).matches("OK")) {
            List<Sales> list = new ArrayList<>();
            salesRepository.findAll().iterator().forEachRemaining(list::add);
            list.removeIf(s -> !s.getDate().matches(date));
            return list;
        } else {
            return null;
        }
    }

    public List<Sales> generateMonthlyReport(String token, String date) {
        if (authenticateSalesperson(token).matches("OK")) {
            List<Sales> list = new ArrayList<>();
            salesRepository.findAll().iterator().forEachRemaining(list::add);
            // The date is stored in DD-MM-YYYY format.
            // The month and year of the passed date is checked.
            list.removeIf(s -> !s.getDate().split("-")[1].matches(date.split("-")[1])
                    && !s.getDate().split("-")[2].matches(date.split("-")[2]));
            return list;
        } else {
            return null;
        }
    }

    public Iterable<Sales> getAllSales(String token) {
        if (authenticateSalesperson(token).matches("OK")) {
            Iterable<Sales> sales = salesRepository.findAll();
            return sales;
        } else {
            return null;
        }
    }

    public Optional<Sales> getSales(String token, Integer id) {
        if (authenticateSalesperson(token).matches("OK")) {
            return salesRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addSales(String token, Sales sales) {
        if (authenticateSalesperson(token).matches("OK")) {
            salesRepository.save(sales);
        }
    }

    public void updateSales(String token, Integer id, Sales sales) {
        if (authenticateSalesperson(token).matches("OK")) {
            salesRepository.save(sales);
        }
    }

    public void deleteSales(String token, Integer id) {
        if (authenticateSalesperson(token).matches("OK")) {
            salesRepository.deleteById(id);
        }
    }

    public String authenticateSalesperson(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://salesperson-authentication-service/saless/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
