package com.example.springcoredemo.springcoredemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.springcoredemo.springcoredemo.payment.CardPayment;
import com.example.springcoredemo.springcoredemo.payment.PaymentService;
import com.example.springcoredemo.springcoredemo.payment.UpiPayment;

@Configuration
@ComponentScan("com.example.springcoredemo.springcoredemo")
public class AppConfig {

    @Bean
    public User createUser() {
        return new User("Aaditya", 21);
    }

    @Bean
    public PaymentService createCardPayment() {
        return new CardPayment();
    }

    @Bean
    @Primary
    public PaymentService createUpiPayment() {
        return new UpiPayment();
    }

    @Bean 
    public OrderService creatOrderService(PaymentService paymentService) {
        return new OrderService(paymentService);
    }
}
