package com.crayon.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.crayon.feign"})
@ComponentScan(value = {"com.crayon"})
public class CrayonAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrayonAdminApplication.class, args);
	}

}
