package com.accenture.microservices.emp.chargecode.master.service;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.accenture.lari.chargecode.domain.ChargeCodeEntity;
import com.accenture.lari.chargecode.repository.ChargeCodeRepository;
import com.accenture.lari.chargecode.service.impl.ChargeCodeServiceImpl;

public class ChargecodeServiceTest {
	
	@Autowired
	ChargeCodeServiceImpl chargeCodeService;
	
	@MockBean
	ChargeCodeRepository chargeCodeRepository;

	@Test
	public void TestChargeCodeValidityTest() {
		Collection<String> requestChargeCodes = Arrays.asList("AAAAA", "A12345", "AB6578");
		Collection<ChargeCodeEntity> responseChargeCodeEntity  = chargeCodeService.getChargeCodes(requestChargeCodes);
		//assert
	}

}
