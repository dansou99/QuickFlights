package com.flights.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.flights")
public class QuickFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickFlightsApplication.class, args);
	}

}
