package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillGeneratorApplication.class, args);
		System.out.println("Application started");
	}

}
