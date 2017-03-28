package com.accenture.microservices.emp.chargecode.master.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lari.chargecode.domain.ChargeCodeEntity;
import com.accenture.lari.chargecode.domain.EmployeeEntity;
import com.accenture.lari.chargecode.repository.ChargeCodeRepository;
import com.accenture.lari.chargecode.resources.dto.ChargeCodeDTO;
import com.accenture.lari.chargecode.resources.dto.EmployeeDTO;
import com.accenture.lari.chargecode.service.impl.ChargeCodeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChargeCodeServiceImpl.class)
public class ChargecodeServiceTest {
	public static final Logger log = LoggerFactory.getLogger(ChargecodeServiceTest.class);
	@Autowired
	ChargeCodeServiceImpl chargeCodeService;
	
	@MockBean
	ChargeCodeRepository chargeCodeRepository;

	@Test
	public void validateChargeCode() throws Exception {
	Collection<ChargeCodeEntity> chareCodeRefEntityList = new ArrayList<ChargeCodeEntity>();
		chareCodeRefEntityList = createChargeCodeObject();
		Collection<String> chargeCodesArray = new ArrayList<>();
		chargeCodesArray.add("AAAAA");
		chargeCodesArray.add("A12345");
		chargeCodesArray.add("AB6578");
		given(this.chargeCodeService.getChargeCodes(chargeCodesArray)).willReturn(chareCodeRefEntityList);
		Collection<ChargeCodeEntity> chareCodeEntityList = this.chargeCodeService.getChargeCodes(chargeCodesArray);
		log.info("from service layer: "+chareCodeEntityList.toString());
		log.info("reference object: "+chareCodeRefEntityList.toString());
		Collection<ChargeCodeEntity> newComapreObject=new ArrayList<ChargeCodeEntity>();
		newComapreObject.addAll(chareCodeRefEntityList);
		/*if(newComapreObject==chareCodeEntityList){
			log.info("Both the objects are same");
		}else{
			log.info("Both the objects are not same");
		}*/
		assertThat(newComapreObject.equals(chareCodeEntityList));
	}
	/**
	 * 
	 * @return Collection<ChargeCodeDTO>
	 * @Objective Generates Reference Chargecode object
	 */
	public Collection<ChargeCodeEntity> createChargeCodeObject(){
		Collection<ChargeCodeEntity> chargeCodeDTO = new ArrayList<>();
		//Collection<EmployeeEntity> employeeDtoList1 = new ArrayList<>();
		//Collection<EmployeeEntity> employeeDtoList2 = new ArrayList<>();
		//Collection<EmployeeEntity> employeeDtoList3 = new ArrayList<>();
		
		Set<EmployeeEntity> employeeDtoList1 = new HashSet<>();
		Set<EmployeeEntity> employeeDtoList2 = new HashSet<>();
		Set<EmployeeEntity> employeeDtoList3 = new HashSet<>();
		
		
		EmployeeEntity employeeDto1 = new EmployeeEntity(12, "Anil", "Bangalore");
		EmployeeEntity employeeDto2 = new EmployeeEntity(13333, "Sharukh", "Bangalore");
		EmployeeEntity employeeDto3 = new EmployeeEntity(12345, "Aditya", "Bangalore");
		employeeDtoList1.add(employeeDto1);
		employeeDtoList2.add(employeeDto2);
		employeeDtoList3.add(employeeDto3);
		ChargeCodeEntity chargeCodeDto1 = new ChargeCodeEntity("AA","COE","Accenture","Active",employeeDtoList1);
		ChargeCodeEntity chargeCodeDto2 = new ChargeCodeEntity("A12345","COE","Accenture","Active",employeeDtoList2);
		ChargeCodeEntity chargeCodeDto3 = new ChargeCodeEntity("AB657","COE","Accenture","Active",employeeDtoList3);
		chargeCodeDTO.add(chargeCodeDto1);
		chargeCodeDTO.add(chargeCodeDto2);
		chargeCodeDTO.add(chargeCodeDto3);
		return chargeCodeDTO;
	}


}
