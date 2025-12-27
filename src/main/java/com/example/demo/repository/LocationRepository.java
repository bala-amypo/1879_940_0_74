package com.example.demo.repository;

import com.example.demo.entity.Location;
import java.util.*;

public interface LocationRepository {
    Optional<Location> findById(Long id);
    List<Location> findAll();
    Location save(Location location);
}
