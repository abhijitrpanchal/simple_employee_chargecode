/**
 * 
 */
package com.accenture.lari.chargecode.resources;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lari.chargecode.domain.ChargeCodeEntity;
import com.accenture.lari.chargecode.resources.dto.ChargeCodeDTO;
import com.accenture.lari.chargecode.service.ChargeCodeService;
import com.accenture.lari.chargecode.utility.ApplicationUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author j.venugopalan
 * 
 *
 */

@RestController
@RequestMapping(value = "/chargecodes", produces = "application/json")
@Api(tags = "Employee Charge Code API")

// @Api(decscription = "Employee Charge Code Service")
public class ChargeCodeMasterController {

	public static final Logger log = LoggerFactory.getLogger(ChargeCodeMasterController.class);

	@Autowired
	ChargeCodeService chargeCodeService;

	/*@Autowired
	private ModelMapper modelMapper;*/
	
	@Autowired
	ApplicationUtils applicationUtils;


	@ApiOperation(notes = "This End point will check if the employee ID has access or is authorized  to the use the given WBS. WBS details are written in json format.", value = "isChargeCodeAuthorized", nickname = "ChargeCodeDetails")
	@RequestMapping(value = "/{wbs}/employees/{empid}", method = RequestMethod.GET)
	public ChargeCodeDTO isChargeCodeAuthorized(
			@ApiParam(value = "ID of the chargecode whose records needs to be looked into the chargecode microservice", required = true) @PathVariable("wbs") String chargeCode,
			@ApiParam(value = "ID of the employee for whom the given chargerecords details are retrieved", required = true) @PathVariable("empid") Integer empid)
			throws Exception {

		log.info("Inside isChargeCodeAuthorized");
		ChargeCodeDTO chargeDTO = null;
		ChargeCodeEntity chargeCodeEntity = chargeCodeService.getChargeCode(chargeCode, empid);
		if(chargeCodeEntity != null){
			chargeDTO = applicationUtils.convertChargeCodeEntityToDto(chargeCodeEntity);
		}		
		return chargeDTO;
	}

	@ApiOperation(notes = "This End point will check if the given WBS is a valid WBS from the list of WBS in DB. WBS details are written in json format.", value = "validateChargeCode", nickname = "EmployeeChargeCode")
	@RequestMapping(value = "/{chargecodes}", method = RequestMethod.GET)
	public Collection<ChargeCodeDTO> getChargeCodes(@PathVariable("chargecodes") String[] chargeCodesList) {
		Collection<String> chargeCodesArray = new ArrayList<>();
		log.info("getChargeCodes: ");
		for (String value : chargeCodesList) {
			chargeCodesArray.add(value);
		}
		Collection<ChargeCodeEntity> chargeCodeEntity = new ArrayList<>();
		log.info("getChargeCodes: "+chargeCodesArray.size());
		chargeCodeEntity = chargeCodeService.getChargeCodes(chargeCodesArray);
		Collection<ChargeCodeDTO> chargeDTO = applicationUtils.convertChargeCodeEntityListToDtoList(chargeCodeEntity);
		return chargeDTO;

	}

}
