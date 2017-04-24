/**
 * 
 */
package com.accenture.lari.chargecode.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.lari.chargecode.domain.ChargeCodeEntity;



/**
 * @author j.venugopalan
 *
 */

public  interface ChargeCodeRepository extends MongoRepository<ChargeCodeEntity, String> {

   public  ChargeCodeEntity findByChargeCode(String chargeCode);
   
   public  ChargeCodeEntity findByChargeCodeAndAuthorizedEmployeesEmployeeId(String chargeCode,Integer employeeId);
   
}

	