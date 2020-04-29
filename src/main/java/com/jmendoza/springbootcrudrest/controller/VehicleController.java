package com.jmendoza.springbootcrudrest.controller;

import com.jmendoza.springbootcrudrest.exception.ResourceNotFoundException;
import com.jmendoza.springbootcrudrest.model.Vehicle;
import com.jmendoza.springbootcrudrest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getUsers() {
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "VehicleController");
        return ResponseEntity.ok().headers(headers).body(vehicleList);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getUser(
            @PathVariable(value = "id") Long vehicleId) throws ResourceNotFoundException {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        return ResponseEntity.ok().body(vehicle);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createUser(@Valid @RequestBody Vehicle vehicle) {
        Vehicle vehicleCreated = vehicleService.createVehicle(vehicle);
        return ResponseEntity.created(URI.create("/users/" + vehicleCreated.getId())).body(vehicleCreated);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity deleteVehicles(
            @PathVariable(value = "id") Long vehicleId) throws ResourceNotFoundException {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.noContent().build();
    }
}
