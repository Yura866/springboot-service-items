package com.springboot.app.item;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AppConfig {	
	
	@Bean("clientRest") RestTemplate registrRestTemplate() {		
		return new RestTemplate();		
	}
}
