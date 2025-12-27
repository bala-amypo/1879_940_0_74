package com.example.demo.repository;

import com.example.demo.entity.Vehicle;
import java.util.*;

public interface VehicleRepository {
    Optional<Vehicle> findById(Long id);
    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
    List<Vehicle> findByUserId(Long userId);
    Vehicle save(Vehicle vehicle);
}
