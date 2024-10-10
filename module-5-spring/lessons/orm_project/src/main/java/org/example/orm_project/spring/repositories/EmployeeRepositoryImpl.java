package org.example.orm_project.spring.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.orm_project.spring.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Employee employee) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(employee);
        entityTransaction.commit();
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeesQuery = entityManager.createQuery("from Employee e", Employee.class);
        return employeesQuery.getResultList();
    }
}
