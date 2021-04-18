package com.chootay.repairreportservice;

import com.chootay.repairreportservice.models.RepairReport;
import com.chootay.repairreportservice.services.RepairReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RepairReportController {
    @Autowired
    private RepairReportService repairReportService;

    @RequestMapping("/repairReports")
    public Iterable<RepairReport> getAllRepairReports(@RequestHeader("Authorization") String token) {
        return repairReportService.getAllRepairReports(token);
    }

    @RequestMapping("/repairReports/{id}")
    public Optional<RepairReport> getRepairReport(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return repairReportService.getRepairReport(token, id);
    }

    @PostMapping("/repairReports")
    public void addRepairReport(@RequestHeader("Authorization") String token, @RequestBody RepairReport repairReport) {
        repairReportService.addRepairReport(token, repairReport);
    }

    @PutMapping("/repairReports/{id}")
    public void updateRepairReport(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody RepairReport repairReport) {
        repairReportService.updateRepairReport(token, id, repairReport);
    }

    @DeleteMapping("/repairReports/{id}")
    public void deleteRepairReport(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        repairReportService.deleteRepairReport(token, id);
    }
}
