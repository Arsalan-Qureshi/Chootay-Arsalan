package com.chootay.salespersonservice.services;

import com.chootay.salespersonservice.models.Salesperson;
import com.chootay.salespersonservice.models.SalespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class SalespersonService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SalespersonRepository salespersonRepository;

    public SalespersonService() {
    }

    public Iterable<Salesperson> getAllSalespersons(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            Iterable<Salesperson> salesperson = salespersonRepository.findAll();
            return salesperson;
        } else {
            return null;
        }
    }

//    public List<Admin> getAll() {
//        List<Admin> list = new ArrayList<>();
//        adminRepository.findAll().iterator().forEachRemaining(list::add);
//        return list;
//    }

//    public Optional<Admin> getAdminByUsername(String token, String userName) {
//        if (authenticateAdmin(token).matches("OK")) {
//            return adminRepository.findByUserName(userName);
//        } else {
//            return null;
//        }
//    }

    public Optional<Salesperson> getSalesperson(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            return salespersonRepository.findById(id);
        } else {
            return null;
        }
    }

    public void addSalesperson(String token, Salesperson salesperson) {
        if (authenticateAdmin(token).matches("OK")) {
            salespersonRepository.save(salesperson);
        }
    }

    public void updateSalesperson(String token, Integer id, Salesperson salesperson) {
        if (authenticateSalesperson(token).matches("OK")) {
            salespersonRepository.save(salesperson);
        }
    }

    public void deleteSalesperson(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            salespersonRepository.deleteById(id);
        }
    }

    public String authenticateSalesperson(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://salesperson-authentication-service/salespersons/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }

    public String authenticateAdmin(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://admin-authentication-service/admins/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
