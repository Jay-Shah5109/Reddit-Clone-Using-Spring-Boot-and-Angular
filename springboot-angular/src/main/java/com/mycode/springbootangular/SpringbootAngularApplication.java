package com.mycode.springbootangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAngularApplication.class, args);
	}

}
