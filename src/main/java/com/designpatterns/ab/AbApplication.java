package com.designpatterns.ab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class AbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbApplication.class, args);
	}

}
