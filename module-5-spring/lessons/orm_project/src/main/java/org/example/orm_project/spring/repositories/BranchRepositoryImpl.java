package org.example.orm_project.spring.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.orm_project.spring.models.Branch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchRepositoryImpl implements BranchRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(Branch branch) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(branch);
        transaction.commit();
    }

    @Override
    public List<Branch> findAllByLocationName(String locationName) {
        TypedQuery<Branch> query = entityManager.createQuery("SELECT branch FROM Branch left join branch.locations location where location.locationName = :locationName", Branch.class);
        query.setParameter("locationName", locationName);
        return query.getResultList();
    }
}
