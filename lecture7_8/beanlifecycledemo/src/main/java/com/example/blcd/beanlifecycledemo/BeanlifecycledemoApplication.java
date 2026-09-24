package com.example.blcd.beanlifecycledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanlifecycledemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanlifecycledemoApplication.class, args);
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// OrderService order = context.getBean(OrderService.class);
		// order.placeOrder();
		// AppConfig config = context.getBean(AppConfig.class);
		// config.demo();
		// CartService cart = context.getBean(CartService.class);
		// System.out.println(cart.getValue(1));

		// context.close();

	}

}
