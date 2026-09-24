package com.example.sbcore.springbootcore;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PayementService payementService;

    public OrderService(PayementService payementService){
        this.payementService=payementService;
    }

    public void placeOrder(){
        payementService.pay();
        System.out.println("Order placed");
    }

}
