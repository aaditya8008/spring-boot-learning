package com.example.scpedemo.beanscopedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanscopedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanscopedemoApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService order = context.getBean(OrderService.class);
		OrderService order2 = context.getBean(OrderService.class);
		System.out.println(order==order2);

	}

}
