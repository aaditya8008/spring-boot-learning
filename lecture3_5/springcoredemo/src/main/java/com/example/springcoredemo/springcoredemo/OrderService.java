package com.example.springcoredemo.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.springcoredemo.springcoredemo.payment.PaymentService;

// @Component
public class OrderService {

   
    private final PaymentService paymentService;

    
    public OrderService(@Qualifier("up")PaymentService paymentService) {
        this.paymentService=paymentService;

    }

    // @Autowired
    // public void setPaymentService(PaymentService paymentService) {
    //     this.paymentService = paymentService;
    // }
    
    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");
    }
}
