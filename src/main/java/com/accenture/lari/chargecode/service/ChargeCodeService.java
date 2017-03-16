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
	
	public ChargeCodeEntity getChargeCode(String chargeCode,Integer employyeId);
	
	public Collection<ChargeCodeEntity> getChargeCodes(Collection<String> chargeCodes);	

}
