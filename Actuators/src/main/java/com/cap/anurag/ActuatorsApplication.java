package com.cap.anurag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@EnableWebSecurity
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ActuatorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorsApplication.class, args);
	}

}
