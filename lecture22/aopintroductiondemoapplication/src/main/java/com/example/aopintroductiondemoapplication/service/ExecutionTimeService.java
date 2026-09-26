package com.example.aopintroductiondemoapplication.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.aopintroductiondemoapplication.dto.StudentDTO;

@Component 
@Primary 
public class ExecutionTimeService implements StudentService {

    private LoggingDecorator loggingDecorator;

    

    public ExecutionTimeService(LoggingDecorator loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }



    @Override
    public void createStudent(StudentDTO student) {
        long start=System.currentTimeMillis();
        loggingDecorator.createStudent(student);
        long end=System.currentTimeMillis();
        System.out.println(end-start);

    }
    
}
