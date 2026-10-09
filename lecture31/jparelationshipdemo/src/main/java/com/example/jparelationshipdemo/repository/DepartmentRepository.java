package com.example.jparelationshipdemo.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.example.jparelationshipdemo.model.Department;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department) {
        entityManager.persist(department);
    }

    public void removeDepartment(Department department) {
        entityManager.remove(department);
    }

    public Department findById(Long id) {
        return entityManager.find(Department.class, id);
    }
}
