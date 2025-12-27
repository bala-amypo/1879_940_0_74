package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

import java.time.LocalDateTime;

public class RouteOptimizationServiceImpl {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository sRepo,
                                        RouteOptimizationResultRepository rRepo) {
        this.shipmentRepository = sRepo;
        this.resultRepository = rRepo;
    }

    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double distance = Math.hypot(
                shipment.getPickupLocation().getLatitude() -
                        shipment.getDropLocation().getLatitude(),
                shipment.getPickupLocation().getLongitude() -
                        shipment.getDropLocation().getLongitude()
        );

        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .shipment(shipment)
                .optimizedDistanceKm(distance)
                .estimatedFuelUsageL(distance / shipment.getVehicle().getFuelEfficiency())
                .generatedAt(LocalDateTime.now())
                .build();

        return resultRepository.save(result);
    }

    public RouteOptimizationResult getResult(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
