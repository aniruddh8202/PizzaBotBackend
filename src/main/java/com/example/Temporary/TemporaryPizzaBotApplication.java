package com.example.Temporary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TemporaryPizzaBotApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TemporaryPizzaBotApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TemporaryPizzaBotApplication.class);
	}
}
