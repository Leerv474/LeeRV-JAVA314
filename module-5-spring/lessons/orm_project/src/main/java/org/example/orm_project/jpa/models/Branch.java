package org.example.orm_project.jpa.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"employees", "locations"})
@Entity(name = "branches_jpa")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "branches")
    private List<Employee> employees;
    @OneToMany(mappedBy = "branches")
    private List<Location> locations;
}
