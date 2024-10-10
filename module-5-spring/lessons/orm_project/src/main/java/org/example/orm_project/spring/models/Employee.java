package org.example.orm_project.spring.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"branches"})
@Entity(name = "employees_spring")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "employee_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "branch_id", referencedColumnName = "id")
            }
    )
    private List<Branch> branches;
}
