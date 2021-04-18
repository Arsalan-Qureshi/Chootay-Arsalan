package com.chootay.repairreportservice.services;

import com.chootay.repairreportservice.models.RepairReport;
import com.chootay.repairreportservice.models.RepairReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RepairReportService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RepairReportRepository repairReportRepository;

    public RepairReportService() {
    }

    public Iterable<RepairReport> getAllRepairReports(String token) {
        if (authenticateMechanic(token).matches("OK")) {
            Iterable<RepairReport> repairReports = repairReportRepository.findAll();
            return repairReports;
        } else {
            return null;
        }
    }

    public Optional<RepairReport> getRepairReport(String token, Integer id) {
        if (authenticateMechanic(token).matches("OK")) {
            return repairReportRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addRepairReport(String token, RepairReport repairReport) {
        if (authenticateMechanic(token).matches("OK")) {
            repairReportRepository.save(repairReport);
        }
    }

    public void updateRepairReport(String token, Integer id, RepairReport repairReport) {
        if (authenticateMechanic(token).matches("OK")) {
            repairReportRepository.save(repairReport);
        }
    }

    public void deleteRepairReport(String token, Integer id) {
        if (authenticateMechanic(token).matches("OK")) {
            repairReportRepository.deleteById(id);
        }
    }

    public String authenticateMechanic(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://mechanic-authentication-service/repairReports/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
