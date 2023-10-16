package com.javapera.biscuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BiscuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiscuitApplication.class, args);
		System.out.println("Server Biscuit Avviato");
	}

}
