package com.chootay.customerservice.services;

import com.chootay.customerservice.models.Customer;
import com.chootay.customerservice.models.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService() {
    }

    public Iterable<Customer> getAllCustomers(String token) {
        if (authenticateSalesperson(token).matches("OK")) {
            Iterable<Customer> customers = customerRepository.findAll();
            return customers;
        } else {
            return null;
        }
    }

    public Optional<Customer> getCustomer(String token, Integer id) {
        if (authenticateSalesperson(token).matches("OK")) {
            return customerRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addCustomer(String token, Customer customer) {
        if (authenticateSalesperson(token).matches("OK")) {
            customerRepository.save(customer);
        }
    }

    public void updateCustomer(String token, Integer id, Customer customer) {
        if (authenticateSalesperson(token).matches("OK")) {
            customerRepository.save(customer);
        }
    }

    public void deleteCustomer(String token, Integer id) {
        if (authenticateSalesperson(token).matches("OK")) {
            customerRepository.deleteById(id);
        }
    }

    public String authenticateSalesperson(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://salesperson-authentication-service/customers/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
