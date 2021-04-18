package com.chootay.customerservice;

import com.chootay.customerservice.models.Customer;
import com.chootay.customerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public Iterable<Customer> getAllCustomers(@RequestHeader("Authorization") String token) {
        return customerService.getAllCustomers(token);
    }

    @RequestMapping("/customers/{id}")
    public Optional<Customer> getCustomer(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return customerService.getCustomer(token, id);
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestHeader("Authorization") String token, @RequestBody Customer customer) {
        customerService.addCustomer(token, customer);
    }

    @PutMapping("/customers/{id}")
    public void updateCustomer(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody Customer customer) {
        customerService.updateCustomer(token, id, customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        customerService.deleteCustomer(token, id);
    }
}
