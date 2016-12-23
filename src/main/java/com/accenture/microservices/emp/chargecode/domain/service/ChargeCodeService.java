/**
 * 
 */
package com.accenture.microservices.emp.chargecode.domain.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public boolean isValidChargeCode(String chargeCode){
		
		List<String> invalidChargeCode = Arrays.asList("AI50000", "BN124444", "CD661234");
		boolean isValid=invalidChargeCode.contains(chargeCode) ? false:true;
		
		return isValid;
	}
	
	public boolean isChargeCodeAuthorized(String empid,String chargeCode){
		

		Map<String,List<String>> empChargeCodeMap = new HashMap<String,List<String>>();
		
		empChargeCodeMap.put("10000000", Arrays.asList("AAAAAAAA", "BBBBBBBB", "CCCCCCCC"));
		empChargeCodeMap.put("10000000", Arrays.asList("AAAAAAAA", "BBBBBBBB", "CCCCCCCC"));
		List chargecodeList= empChargeCodeMap.get(empid);
		boolean isValid=true;
		if(chargecodeList!=null)
			isValid = chargecodeList.contains(chargeCode)? false:true;
		
		return isValid;
	}
	
	
	
	
}
