package com.example.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service 
@Profile ("prod")
public class NotificatioServiceImpl implements NotificationService {
    
    @Override
    public String send() {
        return "Notification sent successfully!";
    }
    
}
