package org.example.orm_project.spring.repositories;

import org.example.orm_project.spring.models.Branch;

import java.util.List;

public interface BranchRepository {
    void save(Branch branch);

    List<Branch> findAllByLocationName(String locationName);
}
