package com.msmoto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msmoto.entity.Bike;
import com.msmoto.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll() {
        List<Bike> bikes = bikeService.getAll();
        if(bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id") int id) {
        Bike bike = bikeService.getBikeById(id);
        if(bike == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bike);
    }

    @PostMapping()
    public ResponseEntity<Bike> save(@RequestBody Bike bike) {
        Bike bikeNew = bikeService.save(bike);
        return ResponseEntity.ok(bikeNew);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") int userId) {
        List<Bike> bikes = bikeService.byUserId(userId);
        if(bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

}