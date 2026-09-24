package com.example.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "staging", "default"})
public class DummyNotificationServiceImpl implements NotificationService {
    
    @Override
    public String send() {
        return "Dummy notification sent successfully!";
    }
    
}
