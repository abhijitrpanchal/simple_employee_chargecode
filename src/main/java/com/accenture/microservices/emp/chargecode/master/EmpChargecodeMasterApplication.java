package com.accenture.microservices.emp.chargecode.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;

import com.accenture.microservices.emp.details.CorrelationHeaderFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Tag;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
 

//@SpringBootApplication(scanBasePackages = {"com.accenture.microservices.emp.chargecode"})
@SpringBootApplication(scanBasePackages = { "com.accenture.microservices.emp.chargecode" })
@EnableAutoConfiguration
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableSwagger2
//@ComponentScan("import static springfox.documentation.builders.PathSelectors.regex")	
@EnableResourceServer
public class EmpChargecodeMasterApplication {
	
	
	@Configuration
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	    @Override
	    public void configure(HttpSecurity http) throws Exception {
	    
			 http
	            .authorizeRequests().antMatchers("/hystrix.stream").permitAll()
			.and()
	   
	            .authorizeRequests().anyRequest().authenticated();
	    
	}
	    
}

	public static void main(String[] args) {
		SpringApplication.run(EmpChargecodeMasterApplication.class, args);
	}
	 @Bean
	    public FilterRegistrationBean correlationHeaderFilter() {
	        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
	        filterRegBean.setFilter(new CorrelationHeaderFilter());
	        filterRegBean.setUrlPatterns(Arrays.asList("/*"));

	        return filterRegBean;
	 }

@Bean
public Docket newAPIChargeCode() {
        return new Docket(DocumentationType.SWAGGER_2)
        		
        		.groupName("chargecode")
        		.apiInfo(apiInfo())
                .select()
                .paths(regex("/chargecodes.*"))
                //.apis(RequestHandlerSelectors.basePackage(ChargeCodeMasterController.class.getPackage().getName()))
                .build();
               // .tags(new Tag("Pet Service", "All apis relating to pets"));
        		// .useDefaultResponseMessages(false)
            //.apiInfo(apiInfo())
            //.select()
            //.paths(regex("/greeting.*"))
            //.paths(Predicates.not(PathSelectors.regex("/error.*")))
            //.build();             
   }
@Component
@Primary
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        enable(SerializationFeature.INDENT_OUTPUT);
    }
}


private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Employee Charge Code API")
            .description("This API is for validating and fetching charge code data for authorized employee with in organization.")
            .version("1.0")
            .contact(new Contact("ATA Lean Architecture Team", "", "ATA.Lean.Arch.Group@accenture.com"))
             //.contact("ATA Lean Architecture Team")
            .license("Accenture License Version")
            //.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
             .build();
    }
}
