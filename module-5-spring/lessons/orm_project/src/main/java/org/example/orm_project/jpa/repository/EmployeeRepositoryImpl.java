package org.example.orm_project.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.TransactionManager;
import lombok.RequiredArgsConstructor;
import org.example.orm_project.jpa.models.Employee;

@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeesRepository {
    private final EntityManager entityManager;

    @Override
    public void save(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        entityManager.persist(employee);
        transaction.commit();
    }
}
