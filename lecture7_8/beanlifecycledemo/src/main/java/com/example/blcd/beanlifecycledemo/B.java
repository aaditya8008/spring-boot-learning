package com.example.blcd.beanlifecycledemo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class B {
    A a;
 
    public void setA(A a) {
        this.a = a;
    }
}
