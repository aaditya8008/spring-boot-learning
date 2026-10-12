package com.example.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/api/students")
public class SpringController {

    @GetMapping
    public ResponseEntity<String> getStudents() {
        return ResponseEntity.ok("Students successfully retrieved");
    }

    @PostMapping
    public ResponseEntity<String> createStudent() {
        return ResponseEntity.ok("Student successfully created");
    }

    @DeleteMapping 
    public ResponseEntity<String> deleteStudent() {
        return ResponseEntity.ok("Student successfully deleted");
    }


    @PutMapping 
    public ResponseEntity<String> updateStudent() {
        return ResponseEntity.ok("Student updated successfully");
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(CsrfToken token) {
        return token;
    }
    

    
    
    
}
