/**
 * 
 */
package com.accenture.microservices.emp.chargecode.web;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.microservices.emp.chargecode.domain.service.ChargeCodeService;
import com.accenture.microservices.emp.chargecode.domain.vo.ChargeCode;

/**
 * @author j.venugopalan
 *
 */
@RestController
public class ChargeCodeMasterController {
	public static final Logger log = LoggerFactory.getLogger(ChargeCodeMasterController.class);
	
	@Autowired
	ChargeCodeService ChargeCodeService;
	
	@RequestMapping(value="/chargecodes", method=RequestMethod.GET)
	public Collection<ChargeCode> getChargeCode(@PathVariable("chargeCode") String chargeCode){
		
		Collection<ChargeCode> chargeCodeList = this.ChargeCodeService.getChargeCode(chargeCode);
		log.info("chargeCode: "+chargeCodeList);
		
		return null;
	}
}
