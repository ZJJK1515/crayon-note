package com.crayon.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.crayon.feign"})
@MapperScan("com.crayon.data.dao")
@EnableTransactionManagement
@ComponentScan(value = {"com.crayon"})
public class CrayonDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrayonDataServiceApplication.class, args);
	}

}
