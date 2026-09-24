package com.example.filterdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.filterdemo.dto.StudentDTO;
import com.example.filterdemo.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("api/students")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Student created successfully");

    }
}
