package com.jmendoza.springbootcrudrest.repository;

import com.jmendoza.springbootcrudrest.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
