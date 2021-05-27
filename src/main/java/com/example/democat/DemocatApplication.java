package com.example.democat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemocatApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocatApplication.class, args);
	}

}
