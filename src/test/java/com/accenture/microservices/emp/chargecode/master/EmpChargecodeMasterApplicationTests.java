package com.accenture.microservices.emp.chargecode.master;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

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
		MvcResult result = mockMvc.perform(get("/chargecodes/AAAAA")).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}

	/**
     * 
     * @throws Exception
     * @Description: negative test case- Unit test with no  wbs
     * @param: null
     * @return: null
     * @expected result: 404
     * 
     *//*
	@Test
	public void validateChargeWithoutWBSCode() throws Exception {
		log.info("Result::: "+mockMvc.perform(get("/chargecodes")));
		MvcResult result = mockMvc.perform(get("/chargecodes")).andExpect(status().isNotFound()).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}

	*//**
     * 
     * @throws Exception
     * @Description: negative test case- Unit test with wrong  wbs
     * @param: wbs
     * @return: null
     * @expected result: null
     * 
     *//*
	@Test
	public void checkChargeCode() throws Exception {
		log.info("Result::: "+mockMvc.perform(get("/chargecodes/A12345")));
		MvcResult result = mockMvc.perform(get("/chargecodes/A12345")).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}

	
	 *//**
     * 
     * @throws Exception
     * @Description: positive test case- Unit test with parameter employeeId and WBS
     * @param: employeeId and WBS
     * @return: Arralylist of Authorized employees
     * @expected result: Arralylist of Authorized employees
     * 
     *//*
	@Test
	public void isChargeCodeAuthorized()throws Exception {
		log.info("Result::: "+mockMvc.perform(get("/chargecodes/AAAAA/employees/10000")));
		MvcResult result = mockMvc.perform(get("/chargecodes/AAAAA/employees/10000")).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}*/
	
}
