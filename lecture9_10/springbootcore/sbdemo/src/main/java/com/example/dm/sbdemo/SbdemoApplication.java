package com.example.dm.sbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SbdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbdemoApplication.class, args);
		// PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
		// paymentGateway.setType("Paytm");
		// paymentGateway.setRetryCount(5);
		// paymentGateway.print();
	}

}
