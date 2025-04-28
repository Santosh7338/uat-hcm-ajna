package com.omfysgroup.ajanhcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.omfysgroup.ajanhcm")
public class AjanHcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjanHcmApplication.class, args);
	}

}
