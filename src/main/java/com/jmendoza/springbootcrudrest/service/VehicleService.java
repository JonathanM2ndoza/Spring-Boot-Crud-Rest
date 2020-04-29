package com.jmendoza.springbootcrudrest.service;

import com.jmendoza.springbootcrudrest.constants.UserConstanst;
import com.jmendoza.springbootcrudrest.exception.ResourceNotFoundException;
import com.jmendoza.springbootcrudrest.model.Vehicle;
import com.jmendoza.springbootcrudrest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicle(Long vehicleId) throws ResourceNotFoundException {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException(UserConstanst.VEHICLE_NOT_FOUND + vehicleId));
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long vehicleId) throws ResourceNotFoundException {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException(UserConstanst.VEHICLE_NOT_FOUND + vehicleId));
        vehicleRepository.delete(vehicle);
    }

    public List<Vehicle> getUserVehicles(Long userId) throws ResourceNotFoundException {

        Optional<List<Vehicle>> optionalVehicleList = vehicleRepository.findByUserId(userId);
        optionalVehicleList.orElseThrow(() -> new ResourceNotFoundException(UserConstanst.VEHICLE_NOT_FOUND.concat(" - ").concat(UserConstanst.USER_NOT_FOUND) + userId));

        return optionalVehicleList.get().stream().map(vehicle -> {
            vehicle.setUser(null);
            return vehicle;
        }).collect(Collectors.toList());
    }
}
