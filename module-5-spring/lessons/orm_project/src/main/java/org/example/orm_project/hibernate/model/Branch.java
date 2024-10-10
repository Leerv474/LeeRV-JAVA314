package org.example.orm_project.hibernate.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"employees", "locations"})
public class Branch {
    private Long id;
    private String name;

    private List<Employee> employees;
    private List<Location> locations;
}
