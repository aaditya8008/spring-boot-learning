package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointCuts {
    
    @Pointcut ("within(com.example.aopdemo.controller..*)")
    public void controllerLayer(){

    }

    @Pointcut ("within(com.example.aopdemo.service..*)")
    public void serviceLayer(){
        
    }

    @Pointcut("execution(public * * (..))")
    public void publicMethod(){

    }

    @Pointcut("serviceLayer()&&publicMethod()")
    public void publicServiceMethod(){

    }

    @Pointcut ("execution(* * get*(..))")
    public void getterMethod(){
        
    }
}
