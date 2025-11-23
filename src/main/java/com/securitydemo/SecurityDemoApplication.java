package com.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Security Demo Spring Boot application.
 * <p>
 * This class is annotated with {@link SpringBootApplication}, which enables
 * Spring Boot's auto-configuration, component scanning, and property support.
 */
@SpringBootApplication
public class SecurityDemoApplication {

	/**
	 * The main method which serves as the entry point for the application.
	 * It bootstraps the Spring application by calling {@link SpringApplication#run}.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	static void main(String[] args) {
		SpringApplication.run(SecurityDemoApplication.class, args);
	}

}
