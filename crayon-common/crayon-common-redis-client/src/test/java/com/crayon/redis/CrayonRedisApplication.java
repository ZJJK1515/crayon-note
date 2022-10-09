package com.crayon.redis;

import com.crayon.redis.config.CrayonRedisConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrayonRedisApplication {



	public static void main(String[] args) {
		SpringApplication.run(CrayonRedisApplication.class, args);
	}

}
