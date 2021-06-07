package com.crayon.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.crayon.feign"})
public class CrayonArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrayonArticleApplication.class, args);
	}

}
