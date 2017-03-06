/**
 * 
 */
package com.accenture.microservices.emp.chargecode.web;


import org.modelmapper.ModelMapper;
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
import com.accenture.microservices.emp.chargecode.master.dto.ChargeCodeDTO;
import com.accenture.microservices.emp.chargecode.domain.Entity.ChargeCodeEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



/**
 * @author j.venugopalan
 * 
 *
 */

@RestController
@RequestMapping(value="/chargecodes",produces = "application/json")
@Api(tags = "Employee Charge Code API")

//@Api(decscription = "Employee Charge Code Service")
public class ChargeCodeMasterController {
	
	public static final Logger log = LoggerFactory.getLogger(ChargeCodeMasterController.class);
	
	@Autowired
	ChargeCodeService ChargeCodeService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@ApiOperation(notes="This End point will check if the given WBS is a valid WBS from the list of WBS in DB. WBS details are written in json format.",value = "validateChargeCode", nickname = "EmployeeChargeCode")
	@RequestMapping(value="/{wbs}", method=RequestMethod.GET)
	public ChargeCodeEntity validateChargeCode(@ApiParam(value = "ID of the chargecode whose records needs to be looked into the chargecode microservice",  required = true) @PathVariable("wbs") String chargeCode){
		
		log.info("Inside ChargeCodeMasterController validateChargeCode WBS entered ::" + chargeCode);
		return this.ChargeCodeService.getChargeCode(chargeCode);

	}
	
	@ApiOperation(notes="This End point will check if the employee ID has access or is authorized  to the use the given WBS. WBS details are written in json format.",value = "isChargeCodeAuthorized", nickname = "ChargeCodeDetails")
	@RequestMapping(value="/{wbs}/employees/{empid}", method=RequestMethod.GET)
	public ChargeCodeDTO isChargeCodeAuthorized(@ApiParam(value = "ID of the chargecode whose records needs to be looked into the chargecode microservice",  required = true) @PathVariable("wbs") String chargeCode,@ApiParam(value = "ID of the employee for whom the given chargerecords details are retrieved",  required = true)@PathVariable("empid") Integer empid) throws Exception{
		
		log.info("Inside isChargeCodeAuthorized");
		ChargeCodeEntity chargeCodeEntity=ChargeCodeService.getChargeCode(chargeCode,empid);
		
		ChargeCodeDTO chargeDTO=convertToDto(chargeCodeEntity);
		return chargeDTO ;
	}
	
	private ChargeCodeDTO convertToDto(ChargeCodeEntity chargeEntity) {
		ChargeCodeDTO chargeDTO = modelMapper.map(chargeEntity, ChargeCodeDTO.class);
	    
	    return chargeDTO;
	}
	
	
}
