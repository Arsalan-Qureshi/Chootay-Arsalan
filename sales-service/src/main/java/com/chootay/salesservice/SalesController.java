package com.chootay.salesservice;

import com.chootay.salesservice.models.Sales;
import com.chootay.salesservice.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SalesController {
    @Autowired
    private SalesService salesService;

    @RequestMapping("/sales")
    public Iterable<Sales> getAllSales(@RequestHeader("Authorization") String token) {
        return salesService.getAllSales(token);
    }

    @RequestMapping("/sales/daily/{date}")
    public Iterable<Sales> generateDailyReport(@RequestHeader("Authorization") String token, @PathVariable("date") String date) {
        return salesService.generateDailyReport(token, date);
    }

    @RequestMapping("/sales/monthly/{date}")
    public Iterable<Sales> generateMonthlyReport(@RequestHeader("Authorization") String token, @PathVariable("date") String date) {
        return salesService.generateMonthlyReport(token, date);
    }

    @RequestMapping("/sales/{id}")
    public Optional<Sales> getSales(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return salesService.getSales(token, id);
    }

    @PostMapping("/sales")
    public void addSales(@RequestHeader("Authorization") String token, @RequestBody Sales sales) {
        salesService.addSales(token, sales);
    }

    @PutMapping("/sales/{id}")
    public void updateSales(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody Sales sales) {
        salesService.updateSales(token, id, sales);
    }

    @DeleteMapping("/sales/{id}")
    public void deleteSales(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        salesService.deleteSales(token, id);
    }
}
