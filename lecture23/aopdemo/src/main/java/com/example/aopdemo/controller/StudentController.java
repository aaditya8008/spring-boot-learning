package com.example.aopdemo.controller;

import com.example.aopdemo.dto.StudentDTO;
import com.example.aopdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/api/students") 
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student){
        return ResponseEntity.ok(studentService.createStudent(student));
    }
    @GetMapping
    public ResponseEntity<String> dummmyMethod(){
        String s="hello";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
   
}
