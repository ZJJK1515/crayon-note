package com.crayonnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@EnableTransactionManagement
@SpringBootApplication
public class CrayonNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrayonNoteApplication.class, args);
    }

}
