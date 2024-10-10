package org.example.orm_project.jpa.repository;

import org.example.orm_project.jpa.models.Branch;

import java.util.List;

public interface BranchRepository {
    void save(Branch branch);
    List<Branch> findAllByLocation_name(String id);
}
