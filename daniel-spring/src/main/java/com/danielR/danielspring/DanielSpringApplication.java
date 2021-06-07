package com.danielR.danielspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DanielSpringApplication {

//	@Bean(name="entityManagerFactory")
	public static void main(String[] args) {
		SpringApplication.run(DanielSpringApplication.class, args);
		System.out.println("x");
	}

}
