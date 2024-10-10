package org.example.orm_project.spring.repositories;

import org.example.orm_project.spring.models.Location;

import java.util.List;

public interface LocationRepository {
    void save(Location location);
    List<Location> findAllByLocationName(String locationName);
}
