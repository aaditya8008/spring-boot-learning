package com.example.springcoredemo.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springcoredemo.springcoredemo.payment.PaymentService;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		OrderService order = context.getBean(OrderService.class);
		order.placeOrder();

		// User user = context.getBean(User.class);
		// System.out.println(user.getName());

		


	}

}


