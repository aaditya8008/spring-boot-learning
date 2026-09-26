package com.example.aopintroductiondemoapplication.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.aopintroductiondemoapplication.dto.StudentDTO;

@Component
public class LoggingDecorator implements StudentService{

    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(StudentDTO student) {
        LoggingServiceUtil.logStart("StudentServiceImpl","createStudent");
        studentServiceImpl.createStudent(student);
        LoggingServiceUtil.logEnd("StudentServiceImpl","createStudent");
    }
    
}
