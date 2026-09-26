package com.example.aopintroductiondemoapplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aopintroductiondemoapplication.dto.StudentDTO;
import com.example.aopintroductiondemoapplication.service.StudentService;
import com.example.aopintroductiondemoapplication.service.StudentServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<String> createStudent(StudentDTO studentDTO){
       studentService.createStudent(studentDTO);
       return ResponseEntity.ok("Done"); 
    }
    
}
