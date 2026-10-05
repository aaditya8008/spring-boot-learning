package org.example.hibernatedemo.repository;


import org.example.hibernatedemo.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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
    public void remove(Student student) {
        entityManager.remove(student);
    }

}
