/**
 * 
 */
package com.accenture.microservices.emp.chargecode.domain.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.microservices.emp.chargecode.domain.repository.ChargeCodeRepository;
import com.accenture.microservices.emp.chargecode.domain.vo.ChargeCode;
import com.accenture.microservices.emp.chargecode.domain.vo.Employee;

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
	
//	public Collection<ChargeCode> getChargeCode(String chargeCode){
//		Collection<ChargeCode> chargeCodeList = chargeCodeRepository.findByChargeCode(chargeCode);
//		return chargeCodeList;
//	}
	
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
	
	
	public ChargeCode getChargeCode(String chargeCode){
		
		ChargeCode chargeCodeObj=new ChargeCode();
		chargeCodeObj.setChargeCode(chargeCode);
		chargeCodeObj.setCompany("Accentre");
		chargeCodeObj.setEngagement("COE");
		chargeCodeObj.setStatus("Open");
		chargeCodeObj.setAuthorizedEmployees(new ArrayList());
		
		Employee empObj=new Employee();
		
		empObj.setEmployeeId(10000000);
		empObj.setName("James");
		empObj.setAddress("Bangalore");
		chargeCodeObj.getAuthorizedEmployees().add(empObj);
		
		empObj=new Employee();
		
		empObj.setEmployeeId(10000001);
		empObj.setName("Anil");
		empObj.setAddress("Bangalore");
		chargeCodeObj.getAuthorizedEmployees().add(empObj);
		
		List<String> invalidChargeCode = Arrays.asList("AI50000", "BN124444", "CD661234");
		if (invalidChargeCode.contains(chargeCode))
			return null ;
		else 
			return chargeCodeObj;
		
		
	}
	
	
	public ChargeCode getChargeCode(String chargeCode,Integer employyeId){
	
	
	
	
		Map<String,List<String>> empChargeCodeMap = new HashMap<String,List<String>>();
		empChargeCodeMap.put("10000000", Arrays.asList("AAAAAAAA", "BBBBBBBB", "CCCCCCCC"));
		empChargeCodeMap.put("10000001", Arrays.asList("AAAAAAAA", "BBBBBBBB", "CCCCCCCC"));
		List chargecodeList= empChargeCodeMap.get(employyeId);
		
		if(chargecodeList!=null && chargecodeList.contains(chargeCode))
			
			return null;
		
		ChargeCode chargeCodeObj=new ChargeCode();
		chargeCodeObj.setChargeCode(chargeCode);
		chargeCodeObj.setCompany("Accentre");
		chargeCodeObj.setEngagement("COE");
		chargeCodeObj.setStatus("Open");
		chargeCodeObj.setAuthorizedEmployees(new ArrayList());
	
		Employee empObj=new Employee();
	
		empObj.setEmployeeId(employyeId);
		empObj.setName("James");
		empObj.setAddress("Bangalore");
		chargeCodeObj.getAuthorizedEmployees().add(empObj);
	
		empObj=new Employee();
	
		empObj.setEmployeeId(10000001);
		empObj.setName("Anil");
		empObj.setAddress("Bangalore");
		chargeCodeObj.getAuthorizedEmployees().add(empObj);
		
		return chargeCodeObj;
	}

	
	
	
	
	
}
