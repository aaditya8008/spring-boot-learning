package com.example.cruddtodemo.service;

import org.springframework.stereotype.Service;

import com.example.cruddtodemo.entity.Student;
import com.example.cruddtodemo.repository.StudentRepository;

@Service 
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
