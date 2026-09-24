package com.example.cruddtodemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruddtodemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
