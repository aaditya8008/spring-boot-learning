package com.example.aopdemo.service;

import com.example.aopdemo.annotation.TrackExecutionTime;
import com.example.aopdemo.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
        warnAfter = 2000,
        operation = "Create Student"
    ) 
    public StudentDTO createStudent(StudentDTO student) {
        System.out.println("Student saved");
        return student;
    }

    @TrackExecutionTime(
        warnAfter = 1500,
        operation = "Get Student"
    )
    public String getStudent(String s) {
        System.out.println(s);
        return s;
    }

    public int dummyMethod() {
        return 0;
    }

}
