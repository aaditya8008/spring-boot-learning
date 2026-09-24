package com.example.lect1.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    
    @GetMapping("hello")
    public String hello() {
        return "<h1>Hello World</h1>";
    }
}
