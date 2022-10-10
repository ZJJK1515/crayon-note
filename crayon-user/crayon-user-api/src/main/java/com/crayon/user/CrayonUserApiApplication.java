package com.crayon.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = "com.crayon")
public class CrayonUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrayonUserApiApplication.class, args);
    }
}
