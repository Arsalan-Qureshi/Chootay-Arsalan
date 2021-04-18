package com.chootay.sparepartservice.services;

import com.chootay.sparepartservice.models.SpareParts;
import com.chootay.sparepartservice.models.SparePartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class SparePartsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SparePartsRepository sparePartsRepository;

    public SparePartsService() {
    }

    public Iterable<SpareParts> getAllSpareParts(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            Iterable<SpareParts> sparePartss = sparePartsRepository.findAll();
            return sparePartss;
        } else {
            return null;
        }
    }

    public Optional<SpareParts> getSpareParts(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            return sparePartsRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addSpareParts(String token, SpareParts spareParts) {
        if (authenticateAdmin(token).matches("OK")) {
            sparePartsRepository.save(spareParts);
        }
    }

    public void updateSpareParts(String token, Integer id, SpareParts spareParts) {
        if (authenticateAdmin(token).matches("OK")) {
            sparePartsRepository.save(spareParts);
        }
    }

    public void deleteSpareParts(String token, Integer id) {
        if (authenticateAdmin(token).matches("OK")) {
            sparePartsRepository.deleteById(id);
        }
    }

    public String authenticateAdmin(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://admin-authentication-service/sparePartss/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
