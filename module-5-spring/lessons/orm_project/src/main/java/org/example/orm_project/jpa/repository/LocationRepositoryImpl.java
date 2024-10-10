package org.example.orm_project.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.example.orm_project.jpa.models.Location;

@RequiredArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {
    private final EntityManager entityManager;

    @Override
    public void save(Location location) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(location);
        entityTransaction.commit();
    }
}
