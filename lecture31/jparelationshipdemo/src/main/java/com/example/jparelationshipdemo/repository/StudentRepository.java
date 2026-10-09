package com.example.jparelationshipdemo.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jparelationshipdemo.model.Student;

import java.util.List;


@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }


    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @EntityGraph(attributePaths = {"department", "profile"})
    public List<Student> findAll() {

    }

}
