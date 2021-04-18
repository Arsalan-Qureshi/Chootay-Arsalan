package com.chootay.bikeservice;

import com.chootay.bikeservice.models.Bike;
import com.chootay.bikeservice.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BikeController {
    @Autowired
    private BikeService bikeService;

    @RequestMapping("/bikes")
    public Iterable<Bike> getAllBikes(@RequestHeader("Authorization") String token) {
        return bikeService.getAllBikes(token);
    }

    @RequestMapping("/bikes/{id}")
    public Optional<Bike> getBike(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return bikeService.getBike(token, id);
    }

    @PostMapping("/bikes")
    public void addBike(@RequestHeader("Authorization") String token, @RequestBody Bike bike) {
        bikeService.addBike(token, bike);
    }

    @PutMapping("/bikes/{id}")
    public void updateBike(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody Bike bike) {
        bikeService.updateBike(token, id, bike);
    }

    @DeleteMapping("/bikes/{id}")
    public void deleteBike(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        bikeService.deleteBike(token, id);
    }
}
