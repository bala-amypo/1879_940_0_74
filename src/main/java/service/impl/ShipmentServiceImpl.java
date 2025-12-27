package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

import java.time.LocalDate;

public class ShipmentServiceImpl {

    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    public ShipmentServiceImpl(ShipmentRepository sRepo,
                               VehicleRepository vRepo,
                               LocationRepository lRepo) {
        this.shipmentRepository = sRepo;
        this.vehicleRepository = vRepo;
        this.locationRepository = lRepo;
    }

    public Shipment createShipment(Long vehicleId, Shipment shipment) {

        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Scheduled date is in the past");
        }

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new IllegalArgumentException("Weight exceeds capacity");
        }

        shipment.setVehicle(vehicle);
        shipment.setPickupLocation(
                locationRepository.findById(shipment.getPickupLocation().getId()).get());
        shipment.setDropLocation(
                locationRepository.findById(shipment.getDropLocation().getId()).get());

        return shipmentRepository.save(shipment);
    }

    public Shipment getShipment(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
