/**
 * 
 */
package com.accenture.microservices.emp.chargecode.domain.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.microservices.emp.chargecode.domain.repository.ChargeCodeRepository;
import com.accenture.microservices.emp.chargecode.domain.vo.ChargeCode;

/**
 * @author j.venugopalan
 *
 */
@Service
public class ChargeCodeService {

	private final ChargeCodeRepository chargeCodeRepository;
	
	@Autowired
	public ChargeCodeService(ChargeCodeRepository chargeCodeRepository){
		this.chargeCodeRepository = chargeCodeRepository;
	}
	
	public Collection<ChargeCode> getChargeCode(String chargeCode){
		Collection<ChargeCode> chargeCodeList = chargeCodeRepository.findByChargeCode(chargeCode);
		return chargeCodeList;
	}
}
