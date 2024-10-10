package org.example.orm_project.hibernate.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"branches"})
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;

    private List<Branch> branches;
}
