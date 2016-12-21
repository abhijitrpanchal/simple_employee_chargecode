/**
 * 
 */
package com.accenture.microservices.emp.chargecode.domain.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

import com.accenture.microservices.emp.chargecode.domain.vo.ChargeCode;

/**
 * @author j.venugopalan
 *
 */

public interface ChargeCodeRepository  extends CrudRepository<ChargeCode, String>{

	@View(designDocument = "byChargeCode_design", viewName = "byChargeCode")
    List<ChargeCode> findByChargeCode(String chargeCode);
}
