package com.crayonnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class CrayonNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrayonNoteApplication.class, args);
    }

}
