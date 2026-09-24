package com.example.crudspringbootdemo.controller;

import com.example.crudspringbootdemo.dto.CreateStudentRequestDTO;
import com.example.crudspringbootdemo.dto.CreateStudentResponseDTO;
import com.example.crudspringbootdemo.dto.UpdateStudentRequestDTO;
import com.example.crudspringbootdemo.dto.UpdateStudentResponseDTO;
import com.example.crudspringbootdemo.entity.Student;
import com.example.crudspringbootdemo.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO studentRequestDTO){ 
        CreateStudentResponseDTO createdStudent=studentService.createStudent(studentRequestDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudent(@PathVariable Long id){
        CreateStudentResponseDTO studentResp=studentService.getStudent(id);
        
        return ResponseEntity.ok(studentResp);

    }


    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent(){
        List<CreateStudentResponseDTO> studentList=studentService.getAllStudent();
        
        return ResponseEntity.ok(studentList);

    }
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@RequestParam Long id,
                                                                 @RequestBody UpdateStudentRequestDTO studentReq){
        UpdateStudentResponseDTO studentResp=studentService.updateStudent(id,studentReq);
        
        return ResponseEntity.ok(studentResp);

    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
      
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        studentService.deleteStudentSoftly(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
