package com.accenture.microservices.emp.chargecode.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@SpringBootApplication(scanBasePackages = {"com.accenture.microservices.emp.chargecode"})
@SpringBootApplication(scanBasePackages = { "com.accenture.microservices.emp.chargecode" })
@EnableAutoConfiguration
@EnableCircuitBreaker
@EnableDiscoveryClient
public class EmpChargecodeMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpChargecodeMasterApplication.class, args);
	}
}
