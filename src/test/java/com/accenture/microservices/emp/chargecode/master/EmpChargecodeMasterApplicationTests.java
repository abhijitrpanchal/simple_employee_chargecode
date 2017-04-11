package com.accenture.microservices.emp.chargecode.master;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.lari.chargecode.EmpChargecodeMasterApplication;
import com.accenture.lari.chargecode.domain.ChargeCodeEntity;
import com.accenture.lari.chargecode.domain.EmployeeEntity;
import com.accenture.lari.chargecode.resources.dto.EmployeeDTO;
//import com.accenture.lari.employees.domain.EmployeeDetails;





@SpringBootTest (classes = EmpChargecodeMasterApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmpChargecodeMasterApplicationTests {

public static final Logger log = LoggerFactory.getLogger(EmpChargecodeMasterApplicationTests.class);
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    
    /**
     * 
     * @throws Exception
     * @Description: positive test case- Unit test with parameter wbs
     * @param: wbs
     * @return: ChargeCode
     * @expected result: ChargeCode document
     * 
     */
	@Test
	public void validateChargeCode() throws Exception {
		log.info("Result::: "+mockMvc.perform(get("/chargecodes/AAAAA")));
		Collection<ChargeCodeEntity> charegcodeRefList = createChargeCodeObject();
		MvcResult chareCodeEntityList = mockMvc.perform(get("/chargecodes/AAAAA")).andDo(print()).andReturn();
		Collection<ChargeCodeEntity> newComapreObject=new ArrayList<ChargeCodeEntity>();
		newComapreObject.addAll(charegcodeRefList);
		assertThat(newComapreObject.equals(chareCodeEntityList));
	}

	/**
	 * 
	 * @return Collection<ChargeCodeDTO>
	 * @Objective Generates Reference Chargecode object
	 */
	public Collection<ChargeCodeEntity> createChargeCodeObject(){
		Collection<ChargeCodeEntity> chargeCodeDTO = new ArrayList<>();
		
		
		Collection<EmployeeEntity> employeeDTO = new ArrayList<>();
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
	
	public Collection<EmployeeEntity> createEmployeeObject(){
		
		Collection<EmployeeEntity> employeeDTO = new ArrayList<>();
		Set<EmployeeEntity> employeeDtoList1 = new HashSet<>();
		Set<EmployeeEntity> employeeDtoList2 = new HashSet<>();
		Set<EmployeeEntity> employeeDtoList3 = new HashSet<>();
		
		
		EmployeeEntity employeeDto1 = new EmployeeEntity(12, "Anil", "Bangalore");
		EmployeeEntity employeeDto2 = new EmployeeEntity(13333, "Sharukh", "Bangalore");
		EmployeeEntity employeeDto3 = new EmployeeEntity(12345, "Aditya", "Bangalore");
		employeeDtoList1.add(employeeDto1);
		employeeDtoList2.add(employeeDto2);
		employeeDtoList3.add(employeeDto3);
		return employeeDTO;
		
	}
	
	/**
     * 
     * @throws Exception
     * @Description: negative test case- Unit test with no  wbs
     * @param: null
     * @return: null
     * @expected result: 404
     * 
     */
	
	@Test
	public void validateChargeWithoutWBSCode() throws Exception {
		log.info("Result::: "+mockMvc.perform(get("/chargecodes")));
		MvcResult result = mockMvc.perform(get("/chargecodes")).andExpect(status().isNotFound()).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}

	/**
     * 
     * @throws Exception
     * @Description: negative test case- Unit test with wrong  wbs
     * @param: wbs
     * @return: null
     * @expected result: null
     * 
     */

	@Test
	public void checkChargeCode() throws Exception {
		log.info("Result::: "+mockMvc.perform(get("/chargecodes/A12345")));
		MvcResult result = mockMvc.perform(get("/chargecodes/A12345")).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}

	
	 /**
     * 
     * @throws Exception
     * @Description: positive test case- Unit test with parameter employeeId and WBS
     * @param: employeeId and WBS
     * @return: Arralylist of Authorized employees
     * @expected result: Arralylist of Authorized employees
     * 
     */

		@Test

	public void isChargeCodeAuthorized()throws Exception {
		log.info("Result::: "+mockMvc.perform(get("/chargecodes/employees/10000")));
		MvcResult result = mockMvc.perform(get("/chargecodes/employees/10000")).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}

	@Test
    public void chargecodeNotFound() throws Exception {

		EmployeeEntity employeeDto1 = new EmployeeEntity(12, "Anil", "Bangalore");
		Set<EmployeeEntity> employeeDtoList1 = new HashSet<>();
		employeeDtoList1.add(employeeDto1);
		ChargeCodeEntity chargeCodeDto1 = new ChargeCodeEntity("AA","COE","Accenture","Active",employeeDtoList1);
		//ChargeCodeEntity chargeCodeDto1 = new ChargeCodeEntity("AA","COE","Accenture","Active",employeeDtoList1);
		MvcResult result = mockMvc.perform(get("/chargecodes")).andExpect(status().isNotFound()).andDo(print()).andReturn();
		log.info("Chargecode not found");
               
    }

	
}
