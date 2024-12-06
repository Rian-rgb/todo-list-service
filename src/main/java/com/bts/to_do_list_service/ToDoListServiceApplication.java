package com.bts.to_do_list_service;

import com.bts.to_do_list_service.properties.SecretProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(SecretProperties.class)
public class ToDoListServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListServiceApplication.class, args);
	}

}
