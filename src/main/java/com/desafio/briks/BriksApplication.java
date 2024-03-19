package com.desafio.briks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BriksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriksApplication.class, args);
	}

}
