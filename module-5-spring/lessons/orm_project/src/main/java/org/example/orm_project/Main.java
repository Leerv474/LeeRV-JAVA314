package org.example.orm_project;

import jakarta.persistence.EntityManager;
import org.example.orm_project.jpa.models.Branch;
import org.example.orm_project.jpa.models.Employee;
import org.example.orm_project.jpa.models.Location;
import org.example.orm_project.jpa.repository.BranchRepository;
import org.example.orm_project.jpa.repository.BranchRepositoryImpl;
import org.example.orm_project.jpa.repository.EmployeeRepositoryImpl;
import org.example.orm_project.jpa.repository.LocationRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static void hibernateConfiguration() {
        Configuration conf = new Configuration();
        conf.configure("hibernate/hibernate.cfg.xml");

        try (SessionFactory sessionFactory = conf.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.createQuery("from Employee as e where e.lastName = 'Ivanov'", Employee.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jpaConfiguration() {
        Configuration conf = new Configuration();
        conf.configure("hibernate/hibernate.cfg.xml");

        SessionFactory sessionFactory = conf.buildSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();

        BranchRepository branchesRepository = new BranchRepositoryImpl(entityManager);
        EmployeeRepositoryImpl employeesRepository = new EmployeeRepositoryImpl(entityManager);
        LocationRepositoryImpl locationsRepository = new LocationRepositoryImpl(entityManager);

        Branch one = Branch.builder()  // transient
                .name("one")
                .build();

        Branch two = Branch.builder()  // transient
                .name("two")
                .build();

        branchesRepository.save(one);  // persistent object
        one.setName("1");  // ORM

        branchesRepository.save(two);
        two.setName("2");

        Location l1 = Location.builder()
                .name("L1")
                .branch(one)
                .build();

        Location l2 = Location.builder()
                .name("L2")
                .branch(one)
                .build();

        locationsRepository.save(l1);
        l1.setName("l1");

        locationsRepository.save(l2);
        l2.setName("l2");

        Employee e1 = Employee.builder()
                .firstName("ivan")
                .lastName("ivanov")
                .branches(new ArrayList<>())
                .build();

        Employee e2 = Employee.builder()
                .firstName("maria")
                .lastName("ivanova")
                .branches(new ArrayList<>())
                .build();
        entityManager.close();
    }
}
