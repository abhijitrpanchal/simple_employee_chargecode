/**
 * 
 */
package com.accenture.lari.chargecode.service.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lari.chargecode.domain.Entity.ChargeCodeEntity;
import com.accenture.lari.chargecode.domain.repository.ChargeCodeRepository;
import com.accenture.lari.chargecode.service.ChargeCodeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author j.venugopalan
 *
 */
@Service
public class ChargeCodeServiceImpl implements ChargeCodeService{
	
	public static final Logger log = LoggerFactory.getLogger(ChargeCodeServiceImpl.class);

	@Autowired
	private  ChargeCodeRepository chargeCodeRepository;

	
	
	/**
	   * This is method returns ChargeCode object for a charge code .
	   * @param null  .
	   * @return ChargeCode.
	   * @exception nothing.
	   * @fallbackMethod handleIsChargeCodeExist
	 */
	
	/*@HystrixCommand(fallbackMethod="handleIsChargeCodeExist")
	public ChargeCodeEntity getChargeCodes(String chargeCode){
		
		log.debug("ChargeCodeServiceImpl: getChargeCode Start" + chargeCode);
		ChargeCodeEntity chargecode =chargeCodeRepository.findByChargeCode(chargeCode);
		log.info("ChargeCodeServiceImpl: chargecode=" + chargeCode);
		log.debug("ChargeCodeServiceImpl: getChargeCode End" + chargeCode);
		
		return chargecode;
		
	}*/
	
	/**
	   * This is method returns ChargeCode object for a charge code and employee id .
	   * @param chargeCode,employyeId .
	   * @return ChargeCode.
	   * @exception nothing.
	   * @fallbackMethod handleIsChargeCodeAuthorised
	 */
	
	@HystrixCommand(fallbackMethod="handleIsChargeCodeAuthorised")
	public ChargeCodeEntity getChargeCode(String chargeCode,Integer employyeId){
	
		log.debug("ChargeCodeServiceImpl: getChargeCode Start");
		ChargeCodeEntity chargecode =chargeCodeRepository.findByChargeCodeAndAuthorizedEmployeesEmployeeId(chargeCode, employyeId);
		log.debug("ChargeCodeServiceImpl: getChargeCode End");
		
		return chargecode;
	}
	
	/* This method will return a null object if the getChargeCode() fails for any reason */
	public ChargeCodeEntity handleIsChargeCodeExist(String chargeCode,Throwable t){
		
		log.debug("ChargeCodeServiceImpl: handleIsChargeCodeExist Start");
		log.info("fallback method handleIsChargeCodeExist called,the error thrown is: "+getErrorStackTrace(t));
		log.debug("ChargeCodeServiceImpl: handleIsChargeCodeExist End");
		return null;
		
	}
	
	/* This method will return a null object if the getChargeCode(String chargeCode,Integer employyeId) fails for any reason */
	public ChargeCodeEntity handleIsChargeCodeAuthorised(String chargeCode,Integer employyeId,Throwable t){
		
		log.debug("ChargeCodeServiceImpl: handleIsChargeCodeAuthorised Start");
		log.info("fallback method called for getChargeCode() ,the error thrown is: "+getErrorStackTrace(t));
		log.debug("ChargeCodeServiceImpl: handleIsChargeCodeAuthorised End");
		
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
	@HystrixCommand(fallbackMethod="getChargeCodeFault")
	public Collection<ChargeCodeEntity> getChargeCodes(Collection<String> chargeCodes){
		log.debug("getChargeCodes ::: START");
		Collection<String> invalidChargeCode = Arrays.asList("AI50000", "BN124444", "CD661234");
		Collection<ChargeCodeEntity> chargeCodeList = new ArrayList<>();
		Boolean expectionStatus = false;
		for(String exce: invalidChargeCode){
			if(chargeCodes.contains(exce)){
				expectionStatus = true;
				break;
			}else{
				expectionStatus = false;
			}
		}
		log.debug("getChargeCodes ::: Invalid chargecode existance in request: "+expectionStatus);
		if(expectionStatus){
			chargeCodeList.add(null);
		}else{
			if(chargeCodes.size() ==1){
				log.debug("Single chargecode in sthe request");
				String chargeCode = "";
				for(String cc: chargeCodes){
					chargeCode = cc;
				}
				ChargeCodeEntity ce = chargeCodeRepository.findByChargeCode(chargeCode);
				chargeCodeList.add(ce);
			}else{
				chargeCodeList = chargeCodeRepository.findAll();	
			}
		}
		log.debug("getChargeCodes ::: END");
		return chargeCodeList;
	}
	
	public Collection<ChargeCodeEntity> getChargeCodeFault(Collection<String> chargeCodes){
		Collection<ChargeCodeEntity> nullChargeCodeEntity = new ArrayList<>();
		return nullChargeCodeEntity;
	}
	
	
	
	
}
