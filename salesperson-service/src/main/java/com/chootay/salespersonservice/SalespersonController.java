package com.chootay.salespersonservice;

import com.chootay.salespersonservice.models.Salesperson;
import com.chootay.salespersonservice.services.SalespersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SalespersonController {
    @Autowired
    private SalespersonService salespersonService;

    @RequestMapping("/salespersons")
    public Iterable<Salesperson> getAllSalespersons(@RequestHeader("Authorization") String token) {
        return salespersonService.getAllSalespersons(token);
    }

//    @RequestMapping("/salespersons")
//    public List<Salesperson> getAllSalespersons() {
//        return salespersonService.getAll();
//    }

//    @RequestMapping("/buyers/search/{userName}")
//    public Optional<Salesperson> getSalespersonByUsername(@RequestHeader("Authorization") String token, @PathVariable("userName") String userName) {
//        return salespersonService.getSalespersonByUsername(token, userName);
//    }

    @RequestMapping("/salespersons/{id}")
    public Optional<Salesperson> getSalesperson(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return salespersonService.getSalesperson(token, id);
    }

    @PostMapping("/salespersons")
    public void addSalesperson(@RequestHeader("Authorization") String token, @RequestBody Salesperson salesperson) {
        salespersonService.addSalesperson(token, salesperson);
    }

    @PutMapping("/salespersons/{id}")
    public void updateSalesperson(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody Salesperson salesperson) {
        salespersonService.updateSalesperson(token, id, salesperson);
    }

    @DeleteMapping("/salespersons/{id}")
    public void deleteSalesperson(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        salespersonService.deleteSalesperson(token, id);
    }
}
