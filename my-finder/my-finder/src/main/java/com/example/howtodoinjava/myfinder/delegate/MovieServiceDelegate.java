package com.example.howtodoinjava.myfinder.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieServiceDelegate {
	@Autowired
	static
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getAllFilmsDataFallback")
	public static String getAllFilmsDataFallback() {
		String response = restTemplate
				.exchange("http://localhost:8098/getFilms"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}).getBody();

		return "All movies " + response;
	}

	@HystrixCommand(fallbackMethod = "getAllActeursDataFallback")
	public static String getAllActeursDataFallback() {
		String response = restTemplate
				.exchange("http://localhost:8098/getActeurs"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}).getBody();

		return "All acteurs " + response;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
