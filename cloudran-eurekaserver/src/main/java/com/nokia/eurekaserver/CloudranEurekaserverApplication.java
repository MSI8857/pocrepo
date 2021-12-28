package com.nokia.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudranEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudranEurekaserverApplication.class, args);
	}

}
