package com.example.aopdemo.service;

import com.example.aopdemo.dto.StudentDTO;


import org.springframework.stereotype.Service;

@Service
public class StudentService {

    
    public StudentDTO createStudent(StudentDTO student){
       System.out.println("Student saved");
       return student;
    }

    public String getStudent(String s) {
        System.out.println(s);
        return s;

}
}