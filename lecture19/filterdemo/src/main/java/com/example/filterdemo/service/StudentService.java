package com.example.filterdemo.service;

import org.springframework.stereotype.Service;

import com.example.filterdemo.dto.StudentDTO;
import com.example.filterdemo.dto.StudentResponseDTO;

@Service 
public class StudentService {
    
    public StudentResponseDTO createStudent(StudentDTO student){
       StudentResponseDTO responseDto=new StudentResponseDTO();
       responseDto.setName(student.getName());
       responseDto.setMessage("Student created successfully");
       return responseDto;
    }
}
