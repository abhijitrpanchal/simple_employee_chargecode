/**
 * 
 */
package com.accenture.microservices.emp.chargecode.domain.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.microservices.emp.chargecode.domain.repository.ChargeCodeRepository;
import com.accenture.microservices.emp.chargecode.domain.vo.ChargeCode;
import com.accenture.microservices.emp.chargecode.domain.vo.Employee;
import com.accenture.microservices.emp.chargecode.web.ChargeCodeMasterController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author j.venugopalan
 *
 */
@Service
public class ChargeCodeService {
	
	public static final Logger log = LoggerFactory.getLogger(ChargeCodeService.class);

	private final ChargeCodeRepository chargeCodeRepository;
	
	@Autowired
	public ChargeCodeService(ChargeCodeRepository chargeCodeRepository){
		this.chargeCodeRepository = chargeCodeRepository;
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
	
	/**
	   * This is method returns ChargeCode object for a charge code .
	   * @param null  .
	   * @return ChargeCode.
	   * @exception nothing.
	   * @fallbackMethod handleIsChargeCodeExist
	 */
	
	@HystrixCommand(fallbackMethod="handleIsChargeCodeExist")
	public ChargeCode getChargeCode(String chargeCode){
		log.debug("ChargeCodeService: getChargeCode Start" + chargeCode);
		
		log.info("ChargeCodeService: chargecode=" + chargeCode);
	
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
		
		log.debug("ChargeCodeService: getChargeCode End" + chargeCode);
		if (invalidChargeCode.contains(chargeCode))
			return null ;
		else 
			return chargeCodeObj;
		
		
	}
	
	/**
	   * This is method returns ChargeCode object for a charge code and employee id .
	   * @param chargeCode,employyeId .
	   * @return ChargeCode.
	   * @exception nothing.
	   * @fallbackMethod handleIsChargeCodeAuthorised
	 */
	
	@HystrixCommand(fallbackMethod="handleIsChargeCodeAuthorised")
	public ChargeCode getChargeCode(String chargeCode,Integer employyeId){
	
		log.debug("ChargeCodeService: getChargeCode Start");
	
		log.debug("ChargeCodeService: chargeCode="+chargeCode+" employyeId ="+employyeId);
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
		
		log.debug("ChargeCodeService: getChargeCode End");
		
		return chargeCodeObj;
	}
	
	/* This method will return a unknown charge code object if the getChargeCode() fails for any reason */
	public ChargeCode handleIsChargeCodeExist(String chargeCode,Throwable t){
		
		log.debug("ChargeCodeService: handleIsChargeCodeExist Start");
		
		log.info("fallback method handleIsChargeCodeExist called,the error thrown is1: "+getErrorStackTrace(t));
		ChargeCode chargeCodeObj=new ChargeCode();
		chargeCodeObj.setChargeCode("unknown");
		chargeCodeObj.setCompany("unknown");
		chargeCodeObj.setEngagement("unknown");
		chargeCodeObj.setStatus("unknown");
		chargeCodeObj.setAuthorizedEmployees(new ArrayList());
		
		log.debug("ChargeCodeService: handleIsChargeCodeExist End");
		return chargeCodeObj;
		
	}
	
	
	public ChargeCode handleIsChargeCodeAuthorised(String chargeCode,Integer employyeId,Throwable t){
		
		log.debug("ChargeCodeService: handleIsChargeCodeAuthorised Start");
		
		log.info("fallback method called for getChargeCode() ,the error thrown is: "+getErrorStackTrace(t));
		
		ChargeCode chargeCodeObj=new ChargeCode();
		chargeCodeObj.setChargeCode("unknown");
		chargeCodeObj.setCompany("unknown");
		chargeCodeObj.setEngagement("unknown");
		chargeCodeObj.setStatus("unknown");
		chargeCodeObj.setAuthorizedEmployees(new ArrayList());
		
		log.debug("ChargeCodeService: handleIsChargeCodeAuthorised End");
		
		return chargeCodeObj;
		
	}
	
	public String getErrorStackTrace(Throwable t){
		
		if(t!=null){
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);
			return sw.toString();
		}else {
			return null;
		}
		
	}

	
	
	
	
	
}
