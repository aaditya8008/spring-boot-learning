package com.example.aopintroductiondemoapplication.repository;

import org.springframework.stereotype.Repository;

import com.example.aopintroductiondemoapplication.dto.StudentDTO;

@Repository 
public class StudentRepository {

    public void save(StudentDTO student) {
        System.out.println("Student save");
    }
    
}
