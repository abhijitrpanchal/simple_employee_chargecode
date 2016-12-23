package com.accenture.microservices.emp.chargecode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accenture.microservices.emp.chargecode.domain.repository.ChargeCodeRepository;

@Configuration
public class ConfigBean {
	
	
	@Bean
	public ChargeCodeRepository chargeCodeRepository() {
		return new ChargeCodeRepository();
	}

}
