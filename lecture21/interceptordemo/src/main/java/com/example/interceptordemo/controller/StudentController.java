package com.example.interceptordemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/api/students")
public class StudentController {
    
    @PostMapping
   public ResponseEntity<String> createStudent() {
        System.out.println("controller method called");
        return ResponseEntity.ok("Student created successfully");
    }
    
}
