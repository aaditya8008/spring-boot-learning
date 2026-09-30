package com.example.aopdemo.aspect;

import com.example.aopdemo.dto.StudentDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // @Pointcut("within(com.example.aopdemo.service..*)"+"&&"+"execution(public * * (..))")
    // public void logPublicServiceMethod(){

    // }

    
    // @Before("@target(org.springframework.stereotype.Service)")
    // public void logBeforeMethod(){
    //     System.out.println("Method Intercepted");
    // }

     @Before("args(com.example.aopdemo.dto.StudentDTO)"+"&&"+"within(com.example.aopdemo.service..*)")
    public void logBeforeMethod(){
        System.out.println("Method Intercepted");
    }


    // @Before("bean(studentService)||bean(studentController)")
    // public void logBeforeMethod(){
    //     System.out.println("Method Intercepted");
    // }
    
    // @Before("annotation(org.springframework.format.annotation.DateTimeFormat)")
    // public void logBeforeMethod(){
    //     System.out.println("Method Intercepted");
    // }

   


    // @Before("within(com.example.aopdemo.service.StudentService)")
    // public void logBeforeMethod(){
    //     System.out.println("Method Intercepted");
    // }

    // @Before("execution(com.example.aopdemo.dto.StudentDTO com.example.aopdemo.service.StudentService.createStudent(com.example.aopdemo.dto.StudentDTO))")
    // public void logBeforeMethod2(){
    //     System.out.println("Method Intercepted");
    // }

}
