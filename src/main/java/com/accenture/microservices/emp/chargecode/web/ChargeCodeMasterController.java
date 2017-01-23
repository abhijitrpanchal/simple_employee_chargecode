/**
 * 
 */
package com.accenture.microservices.emp.chargecode.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.microservices.emp.chargecode.domain.service.ChargeCodeService;
import com.accenture.microservices.emp.chargecode.domain.vo.ChargeCode;


/**
 * @author j.venugopalan
 * 
 *
 */

@RestController
@RequestMapping(value="/chargecodes")
public class ChargeCodeMasterController {
	public static final Logger log = LoggerFactory.getLogger(ChargeCodeMasterController.class);
	
	@Autowired
	ChargeCodeService ChargeCodeService;

	
	@RequestMapping(value="/{wbs}", method=RequestMethod.GET)
	public ChargeCode validateChargeCode(@PathVariable("wbs") String chargeCode){
		
		log.info("Inside validateChargeCode");
		return this.ChargeCodeService.getChargeCode(chargeCode);

	}
	
	@RequestMapping(value="/{wbs}/employees/{empid}", method=RequestMethod.GET)
	public ChargeCode isChargeCodeAuthorized(@PathVariable("wbs") String chargeCode,@PathVariable("empid") Integer empid){
		
		log.info("Inside isChargeCodeAuthorized");
		return this.ChargeCodeService.getChargeCode(chargeCode,empid);
	}
	
	
}
