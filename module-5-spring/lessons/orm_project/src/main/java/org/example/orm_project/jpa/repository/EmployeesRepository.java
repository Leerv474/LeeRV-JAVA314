package org.example.orm_project.jpa.repository;

import org.example.orm_project.jpa.models.Employee;

public interface EmployeesRepository {
    void save(Employee employee);
}
