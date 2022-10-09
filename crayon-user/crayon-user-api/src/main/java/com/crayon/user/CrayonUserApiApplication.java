package com.crayon.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CrayonUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrayonUserApiApplication.class, args);
    }
}
