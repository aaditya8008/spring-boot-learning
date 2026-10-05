package org.example.hibernatedemo.service;


import org.example.hibernatedemo.model.Student;
import org.example.hibernatedemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional 
    public void createStudent(Student student) {
        studentRepository.save(student);
    }


    @Transactional 
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional 
    public void updateStudent(Student student, Long id) {
        Student existingStudent = studentRepository.findById(id);
        if (existingStudent == null) {
            throw new RuntimeException("Student not found with id: " + id);
        }

            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setAge(student.getAge());
            
     

    }

    @Transactional 
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);
        if (student != null) {
            studentRepository.remove(student);}
            else {
                throw new RuntimeException("Student not found with id: " + id);}

                studentRepository.remove(student);

    }
}
