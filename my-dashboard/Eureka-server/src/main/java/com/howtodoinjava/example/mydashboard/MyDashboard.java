package com.howtodoinjava.example.mydashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer

public class MyDashboard {

	public static void main(String[] args) {
		SpringApplication.run(MyDashboard.class, args);
	}
}
