package com.example.cruddtodemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddtodemo.entity.Student;
import com.example.cruddtodemo.service.StudentService;

@RestController 
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    

    public ResponseEntity<Student> create(@RequestBody Student student) {
       Student studentResponse = studentService.createStudent(student);
       return ResponseEntity.ok(studentResponse);
    }
    
}
