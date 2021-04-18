package com.chootay.sparepartservice;

import com.chootay.sparepartservice.models.SpareParts;
import com.chootay.sparepartservice.services.SparePartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SparePartsController {
    @Autowired
    private SparePartsService sparePartsService;

    @RequestMapping("/spareParts")
    public Iterable<SpareParts> getAllSpareParts(@RequestHeader("Authorization") String token) {
        return sparePartsService.getAllSpareParts(token);
    }

    @RequestMapping("/spareParts/{id}")
    public Optional<SpareParts> getSpareParts(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        return sparePartsService.getSpareParts(token, id);
    }

    @PostMapping("/spareParts")
    public void addSpareParts(@RequestHeader("Authorization") String token, @RequestBody SpareParts spareParts) {
        sparePartsService.addSpareParts(token, spareParts);
    }

    @PutMapping("/spareParts/{id}")
    public void updateSpareParts(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id, @RequestBody SpareParts spareParts) {
        sparePartsService.updateSpareParts(token, id, spareParts);
    }

    @DeleteMapping("/spareParts/{id}")
    public void deleteSpareParts(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) {
        sparePartsService.deleteSpareParts(token, id);
    }
}
