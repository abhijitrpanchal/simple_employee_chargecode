/**
 * 
 */
package com.accenture.microservices.emp.chargecode.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.accenture.microservices.emp.chargecode.domain.Entity.ChargeCodeEntity;


/**
 * @author j.venugopalan
 *
 */

public  interface ChargeCodeRepository extends JpaRepository<ChargeCodeEntity, String> {

   public  ChargeCodeEntity findByChargeCode(String chargeCode);
   
   public  ChargeCodeEntity findByChargeCodeAndAuthorizedEmployeesEmployeeId(String chargeCode,Integer employeeId);
   
}
