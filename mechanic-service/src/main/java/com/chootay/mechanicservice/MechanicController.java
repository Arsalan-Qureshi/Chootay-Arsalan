package com.chootay.mechanicservice;

import com.chootay.mechanicservice.models.Mechanic;
import com.chootay.mechanicservice.services.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MechanicController {
    @Autowired
    private MechanicService mechanicService;

    @RequestMapping("/mechanics")
    public Iterable<Mechanic> getAllMechanics(@RequestHeader("Authorization") String token) {
        return mechanicService.getAllMechanics(token);
    }

//    @RequestMapping("/mechanics")
//    public List<Mechanic> getAllMechanics() {
//        return mechanicService.getAll();
//    }

//    @RequestMapping("/buyers/search/{userName}")
//    public Optional<Mechanic> getMechanicByUsername(@RequestHeader("Authorization") String token, @PathVariable("userName") String userName) {
//        return mechanicService.getMechanicByUsername(token, userName);
//    }

    @RequestMapping("/mechanics/{id}")
    public Optional<Mechanic> getMechanic(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return mechanicService.getMechanic(token, id);
    }

    @PostMapping("/mechanics")
    public void addMechanic(@RequestHeader("Authorization") String token, @RequestBody Mechanic mechanic) {
        mechanicService.addMechanic(token, mechanic);
    }

    @PutMapping("/mechanics/{id}")
    public void updateMechanic(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody Mechanic mechanic) {
        mechanicService.updateMechanic(token, id, mechanic);
    }

    @DeleteMapping("/mechanics/{id}")
    public void deleteMechanic(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        mechanicService.deleteMechanic(token, id);
    }
}
