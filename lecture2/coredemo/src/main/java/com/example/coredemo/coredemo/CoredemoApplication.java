package com.example.coredemo.coredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.coredemo.coredemo.notification.EmailService;
import com.example.coredemo.coredemo.notification.SmsService;

@SpringBootApplication
public class CoredemoApplication {

	public static void main(String[] args) {
		OrderService order = new OrderService();
		order.sendNotification(new EmailService());
		order.placeOrder();
		SpringApplication.run(CoredemoApplication.class, args);
	}

}
