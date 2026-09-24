package com.example.coredemo.coredemo;

import com.example.coredemo.coredemo.notification.EmailService;
import com.example.coredemo.coredemo.notification.NotificationService;
import com.example.coredemo.coredemo.notification.PopUpNotificationService;

public class OrderService {

    NotificationService notification ;

    public OrderService (NotificationService notification){
        this.notification = notification;
    }

    public OrderService (){
        
    }

    public void placeOrder(){
        System.out.println("Order Placed");
        notification.sendNotification();
    }

    public void sendNotification(NotificationService notification) {
        this.notification = notification;
    }
}
