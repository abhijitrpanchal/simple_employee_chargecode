/**
 * 
 */
package com.accenture.lari.chargecode.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lari.chargecode.domain.Entity.ChargeCodeEntity;


/**
 * @author j.venugopalan
 *
 */

public  interface ChargeCodeRepository extends JpaRepository<ChargeCodeEntity, String> {

   public  ChargeCodeEntity findByChargeCode(String chargeCode);
   
   public  ChargeCodeEntity findByChargeCodeAndAuthorizedEmployeesEmployeeId(String chargeCode,Integer employeeId);
   
}
