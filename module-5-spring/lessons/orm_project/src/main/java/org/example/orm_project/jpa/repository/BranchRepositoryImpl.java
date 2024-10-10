package org.example.orm_project.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.example.orm_project.jpa.models.Branch;

import java.util.List;

@RequiredArgsConstructor
public class BranchRepositoryImpl implements BranchRepository{
    private final EntityManager entityManager;
    @Override
    public void save(Branch branch) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(branch);
        transaction.commit();
    }

    @Override
    public List<Branch> findAllByLocation_name(String locationName) {
        TypedQuery<Branch> query = entityManager.createQuery("SELECT branch FROM Branch left join branch.locations location where location.locationName = :locationName", Branch.class);
        query.setParameter("locationName", locationName);
        return query.getResultList();
    }
}
