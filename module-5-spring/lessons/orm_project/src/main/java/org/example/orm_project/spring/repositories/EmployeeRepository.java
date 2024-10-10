package org.example.orm_project.spring.repositories;

import org.example.orm_project.spring.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    public void save(Employee employee);
    List<Employee> findAll();
}
