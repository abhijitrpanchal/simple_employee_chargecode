/**
 * 
 */
package com.accenture.lari.chargecode.service;

import java.util.Collection;

import com.accenture.lari.chargecode.domain.Entity.ChargeCodeEntity;

/**
 * @author j.venugopalan
 *
 */
public interface ChargeCodeService {
	
	//public ChargeCodeEntity getChargeCodes(String chargeCode);
	
	public ChargeCodeEntity getChargeCode(String chargeCode, Integer empId);
	
	public Collection<ChargeCodeEntity> getChargeCodes(Collection<String> chargeCodes);	

}
