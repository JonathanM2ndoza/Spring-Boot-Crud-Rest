package com.jmendoza.springbootcrudrest.repository;

import com.jmendoza.springbootcrudrest.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<List<Vehicle>> findByUserId(Long userId);

    Optional<Vehicle> findByUserIdAndId(Long userId, Long vehicleId);
}
