package com.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name="service-products")
@EnableFeignClients
@SpringBootApplication
public class SpringbootServiceItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceItemApplication.class, args);
	}

}
