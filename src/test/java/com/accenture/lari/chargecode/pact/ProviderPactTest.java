package com.accenture.lari.chargecode.pact;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestContextManager;


import com.accenture.lari.chargecode.EmpChargecodeMasterApplication;
import com.accenture.lari.chargecode.domain.ChargeCodeEntity;
import com.accenture.lari.chargecode.domain.EmployeeEntity;
import com.accenture.lari.chargecode.repository.ChargeCodeRepository;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.TestTarget;

import java.util.HashSet;
import java.util.Set;



@Profile("pact_test")

@RunWith(PactRunner.class)
@Provider("chargecodes")
@PactFolder(ChargeCodeTestConstants.pactFolder)

@SpringBootTest(
  classes = EmpChargecodeMasterApplication.class,
  webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT,
  properties = {"server.port=8080"}
)

public class ProviderPactTest {
	
	@Autowired
	private ChargeCodeRepository chargeCodeRepository;
	
	

    @TestTarget
    public final HttpTarget target = new HttpTarget(8080);


    @Before
    public void beforeClass() throws Exception {
    	
    	 new TestContextManager(getClass()).prepareTestInstance(this);
    		
    }
    
    
    @State("given charge code A56789 exists")	
    public void toDefaultState() {
    	
    	EmployeeEntity EmployeeEntity=new EmployeeEntity(11111,"Prithvi","Bangalore");
    	Set<EmployeeEntity> employees=new HashSet<EmployeeEntity>();
    	employees.add(EmployeeEntity);
    	
    	ChargeCodeEntity chargeCode=new ChargeCodeEntity("A56789","COE","Accenture","Active",employees);
    	chargeCodeRepository.save(chargeCode);

    }

}