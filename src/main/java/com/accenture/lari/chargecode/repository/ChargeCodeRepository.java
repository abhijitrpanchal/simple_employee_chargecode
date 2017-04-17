/**
 * 
 */
package com.accenture.lari.chargecode.repository;


import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.accenture.lari.chargecode.domain.ChargeCodeEntity;



/**
 * @author j.venugopalan
 *
 */

public  interface ChargeCodeRepository extends JpaRepository<ChargeCodeEntity, String> {

   public  ChargeCodeEntity findByChargeCode(String chargeCode);
   
   public  ChargeCodeEntity findByChargeCodeAndAuthorizedEmployeesEmployeeId(String chargeCode,Integer employeeId);
   
}

/*public  interface ChargeCodeRepository extends CrudRepository<ChargeCodeEntity, String>{

	@View(designDocument = "chargecodes", viewName = "byChargeCode")
	ChargeCodeEntity findByChargeCode(String chargeCode);  
	
	@View(designDocument = "chargecodeandemployee", viewName = "byChargeCodeEmployeeId")
	ChargeCodeEntity findByChargeCodeAndAuthorizedEmployeesEmployeeId(String chargeCode, Integer employeeId);
	
	
	}*/
	