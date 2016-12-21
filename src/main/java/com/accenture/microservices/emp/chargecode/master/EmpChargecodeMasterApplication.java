package com.accenture.microservices.emp.chargecode.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.accenture.microservices.emp.chargecode"})
@SpringBootApplication
@EnableAutoConfiguration
public class EmpChargecodeMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpChargecodeMasterApplication.class, args);
	}
}
