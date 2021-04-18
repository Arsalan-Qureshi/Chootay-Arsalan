package com.chootay.adminservice.services;

import com.chootay.adminservice.models.Admin;
import com.chootay.adminservice.models.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AdminRepository adminRepository;

    public AdminService() {
    }

    public Iterable<Admin> getAllAdmins(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            Iterable<Admin> admins = adminRepository.findAll();
            return admins;
        } else {
            return null;
        }
    }

    public Optional<Admin> getAdmin(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            return adminRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addAdmin(String token, Admin admin) {
        if (authenticateAdmin(token).matches("OK")) {
            adminRepository.save(admin);
        }
    }

    public void updateAdmin(String token, Integer id, Admin admin) {
        if (authenticateAdmin(token).matches("OK")) {
            adminRepository.save(admin);
        }
    }

    public void deleteAdmin(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            adminRepository.deleteById(id);
        }
    }

    public String authenticateAdmin(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://admin-authentication-service/admins/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
