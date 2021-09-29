package com.HRApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;


@SpringBootApplication(exclude={JacksonAutoConfiguration.class, JmxAutoConfiguration.class})
public class HrAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrAppApplication.class, args);
	}



}
