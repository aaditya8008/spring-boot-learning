package com.example.blcd.beanlifecycledemo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class A {
    B b;
    public A(B b) {
        this.b = b;
    }

    @PostConstruct
    public void setB(A a) {
        b.setA(this);
    }
}
