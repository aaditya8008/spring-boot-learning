package com.example.aopintroductiondemoapplication.service;

import org.springframework.stereotype.Service;

import com.example.aopintroductiondemoapplication.dto.StudentDTO;
import com.example.aopintroductiondemoapplication.repository.StudentRepository;

@Service 
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;   
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void createStudent(StudentDTO student){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // LoggingServiceUtil.logStart("StudentService", "createStudent");
        studentRepository.save(student);
        // LoggingServiceUtil.logEnd("StudentService", "createStudent");
       
    }
    
}
