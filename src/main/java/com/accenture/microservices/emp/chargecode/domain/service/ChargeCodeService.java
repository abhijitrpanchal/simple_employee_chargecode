/**
 * 
 */
package com.accenture.microservices.emp.chargecode.domain.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.microservices.emp.chargecode.domain.Entity.ChargeCodeEntity;
import com.accenture.microservices.emp.chargecode.domain.repository.ChargeCodeRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author j.venugopalan
 *
 */
@Service
public class ChargeCodeService {
	
	public static final Logger log = LoggerFactory.getLogger(ChargeCodeService.class);

	@Autowired
	private  ChargeCodeRepository chargeCodeRepository;

	
	
	/**
	   * This is method returns ChargeCode object for a charge code .
	   * @param null  .
	   * @return ChargeCode.
	   * @exception nothing.
	   * @fallbackMethod handleIsChargeCodeExist
	 */
	
	@HystrixCommand(fallbackMethod="handleIsChargeCodeExist")
	public ChargeCodeEntity getChargeCode(String chargeCode){
		
		log.debug("ChargeCodeService: getChargeCode Start" + chargeCode);
		ChargeCodeEntity chargecode =chargeCodeRepository.findByChargeCode(chargeCode);
		log.info("ChargeCodeService: chargecode=" + chargeCode);
		log.debug("ChargeCodeService: getChargeCode End" + chargeCode);
		
		return chargecode;
		
	}
	
	/**
	   * This is method returns ChargeCode object for a charge code and employee id .
	   * @param chargeCode,employyeId .
	   * @return ChargeCode.
	   * @exception nothing.
	   * @fallbackMethod handleIsChargeCodeAuthorised
	 */
	
	@HystrixCommand(fallbackMethod="handleIsChargeCodeAuthorised")
	public ChargeCodeEntity getChargeCode(String chargeCode,Integer employyeId){
	
		log.debug("ChargeCodeService: getChargeCode Start");
		ChargeCodeEntity chargecode =chargeCodeRepository.findByChargeCodeAndAuthorizedEmployeesEmployeeId(chargeCode, employyeId);
		log.debug("ChargeCodeService: getChargeCode End");
		
		return chargecode;
	}
	
	/* This method will return a null object if the getChargeCode() fails for any reason */
	public ChargeCodeEntity handleIsChargeCodeExist(String chargeCode,Throwable t){
		
		log.debug("ChargeCodeService: handleIsChargeCodeExist Start");
		log.info("fallback method handleIsChargeCodeExist called,the error thrown is: "+getErrorStackTrace(t));
		log.debug("ChargeCodeService: handleIsChargeCodeExist End");
		return null;
		
	}
	
	/* This method will return a null object if the getChargeCode(String chargeCode,Integer employyeId) fails for any reason */
	public ChargeCodeEntity handleIsChargeCodeAuthorised(String chargeCode,Integer employyeId,Throwable t){
		
		log.debug("ChargeCodeService: handleIsChargeCodeAuthorised Start");
		log.info("fallback method called for getChargeCode() ,the error thrown is: "+getErrorStackTrace(t));
		log.debug("ChargeCodeService: handleIsChargeCodeAuthorised End");
		
		return null;
		
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
	//@HystrixCommand(fallbackMethod="handleIsChargeCodeExist")
	public Collection<ChargeCodeEntity> getChargeCodes(Collection<String> chargeCodes){
		log.debug("ChargeCodeService: getChargeCode Start" + chargeCodes);
		
		Collection<String> invalidChargeCode = Arrays.asList("AI50000", "BN124444", "CD661234");
		Collection<ChargeCodeEntity> chargeCodeList = new ArrayList<>();
		Boolean expectionStatus = false;
		if(chargeCodes.contains(invalidChargeCode)){
			expectionStatus = true;
		}else{
			expectionStatus = false;
		}
		
		if(expectionStatus){
			chargeCodeList.add(null);
		}else{
			chargeCodeList = chargeCodeRepository.findAll();
		}
			return chargeCodeList;
	}
	
	
	
	
	
}
