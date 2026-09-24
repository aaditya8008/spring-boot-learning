package com.example.cdd.circulardependencydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;

import com.example.cdd.circulardependencydemo.simple.A;

@SpringBootApplication
public class CirculardependencydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CirculardependencydemoApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		OrderService order = context.getBean(OrderService.class);
		order.placeOrder();

	
	}

}
