package com.chootay.mechanicservice.services;

import com.chootay.mechanicservice.models.Mechanic;
import com.chootay.mechanicservice.models.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MechanicService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MechanicRepository mechanicRepository;

    public MechanicService() {
    }

    public Iterable<Mechanic> getAllMechanics(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            Iterable<Mechanic> mechanics = mechanicRepository.findAll();
            return mechanics;
        } else {
            return null;
        }
    }

    public Optional<Mechanic> getMechanic(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            return mechanicRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addMechanic(String token, Mechanic mechanic) {
        if (authenticateAdmin(token).matches("OK")) {
            mechanicRepository.save(mechanic);
        }
    }

    public void updateMechanic(String token, Integer id, Mechanic mechanic) {
        if (authenticateMechanic(token).matches("OK")) {
            mechanicRepository.save(mechanic);
        }
    }

    public void deleteMechanic(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            mechanicRepository.deleteById(id);
        }
    }

    public String authenticateMechanic(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://mechanic-authentication-service/mechanics/authenticate", HttpMethod.GET, entity, String.class);
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
