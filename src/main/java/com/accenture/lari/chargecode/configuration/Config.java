/**
 * 
 */
package com.accenture.lari.chargecode.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;


/**
 * @author j.venugopalan
 *
 */
@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.accenture.lari.chargecode" })
public class Config extends AbstractCouchbaseConfiguration {
	
	@Value("${couchbaseDB.url}")
	private String couchbaseDBUrl; 
	
    @Override
    protected List<String> getBootstrapHosts() {
    	return Arrays.asList(couchbaseDBUrl, couchbaseDBUrl);
       
    }

    @Override
    protected String getBucketName() {
        return "chargecodes";
    }

    @Override
    protected String getBucketPassword() {
        return "ACC@123*";
    }
 /* 
    @Bean    
    public RequestInterceptor requestTokenBearerInterceptor() {

        return new RequestInterceptor() {

            @Override
            public void apply(RequestTemplate requestTemplate) {

                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)

                SecurityContextHolder.getContext().getAuthentication()
                        .getDetails();

                requestTemplate.header("Authorization",
                        "bearer " + details.getTokenValue());

            }

        };

    }*/
}
