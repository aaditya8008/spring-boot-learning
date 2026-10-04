package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        //studentRepository.createStudent(new Student("karan","karan@gmail.com",40));
        //studentRepository.updateStudent(new Student("karan negi","karan@gmail.com",45),8L);
       studentRepository.getStudent();
       // studentRepository.deleteStudent(6L);





    }
}