package com.template.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.template")
public class MultiModuleHexagonalTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiModuleHexagonalTemplateApplication.class, args);
	}

}
