package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;

import java.util.List;

public class LocationServiceImpl {

    private final LocationRepository repository;

    public LocationServiceImpl(LocationRepository repo) {
        this.repository = repo;
    }

    public Location createLocation(Location location) {
        if (location.getLatitude() < -90 || location.getLatitude() > 90) {
            throw new IllegalArgumentException("Invalid latitude");
        }
        return repository.save(location);
    }

    public List<Location> getAllLocations() {
        return repository.findAll();
    }
}
