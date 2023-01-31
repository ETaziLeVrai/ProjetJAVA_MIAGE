package com.howtodoinjava.example.mymovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyMovie {

	public static void main(String[] args) {
		SpringApplication.run(MyMovie.class, args);
	}
}
