package com.example.blcd.beanlifecycledemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
   
    // @Bean(initMethod = "start", destroyMethod = "stop")
    // public CartService getCaerBean() {
    //     return new CartService();
    // }
}
