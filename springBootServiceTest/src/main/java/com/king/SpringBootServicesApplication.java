package com.king;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServicesApplication.class, args);
	}

	
}
