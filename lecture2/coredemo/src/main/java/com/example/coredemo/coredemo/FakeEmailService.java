package com.example.coredemo.coredemo;

import com.example.coredemo.coredemo.notification.NotificationService;

public class FakeEmailService implements NotificationService {

    @Override
    public void sendNotification() {
       System.out.println("Dummy Email sent");
    }
    
}
