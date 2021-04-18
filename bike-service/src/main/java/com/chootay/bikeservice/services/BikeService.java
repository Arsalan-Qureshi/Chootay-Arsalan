package com.chootay.bikeservice.services;

import com.chootay.bikeservice.models.Bike;
import com.chootay.bikeservice.models.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BikeRepository bikeRepository;

    public BikeService() {
    }

    public Iterable<Bike> getAllBikes(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            Iterable<Bike> bikes = bikeRepository.findAll();
            return bikes;
        } else {
            return null;
        }
    }

    public Optional<Bike> getBike(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            return bikeRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addBike(String token, Bike bike) {
        if (authenticateAdmin(token).matches("OK")) {
            bikeRepository.save(bike);
        }
    }

    public void updateBike(String token, Integer id, Bike bike) {
        if (authenticateAdmin(token).matches("OK")) {
            bikeRepository.save(bike);
        }
    }

    public void deleteBike(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            bikeRepository.deleteById(id);
        }
    }

    public String authenticateAdmin(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://admin-authentication-service/bikes/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
