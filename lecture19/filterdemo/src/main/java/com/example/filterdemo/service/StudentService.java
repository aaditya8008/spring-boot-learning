package com.example.filterdemo.service;

import org.springframework.stereotype.Service;

import com.example.filterdemo.dto.StudentDTO;

@Service 
public class StudentService {
    
    public void createStudent(StudentDTO student){
        System.out.println("Student created successfully");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Email: " + student.getEmail());
        // try {
        //     Thread.sleep(2000); // Simulate a delay of 2 seconds
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
}
