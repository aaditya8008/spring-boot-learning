package com.example.beaninit.beaninitializationdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeaninitializationdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeaninitializationdemoApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService order = context.getBean(OrderService.class);
	
	}

}
