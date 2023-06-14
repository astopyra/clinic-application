package com.artur.ClinicApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ClinicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicAppApplication.class, args);
	}

}
