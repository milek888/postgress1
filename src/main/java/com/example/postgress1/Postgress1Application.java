package com.example.postgress1;

import com.example.postgress1.infrastructure.DataBaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataBaseProperties.class)
public class Postgress1Application {

	public static void main(String[] args) {
		SpringApplication.run(Postgress1Application.class, args);
	}

}
