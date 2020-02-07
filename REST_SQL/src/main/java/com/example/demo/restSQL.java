package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@SpringBootApplication
@PropertySource("classpath:message.properties")
public class restSQL {

	public static void main(String[] args) {
		SpringApplication.run(restSQL.class, args);
	}

}
