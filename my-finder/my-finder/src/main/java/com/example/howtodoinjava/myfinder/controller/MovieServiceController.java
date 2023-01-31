package com.example.howtodoinjava.myfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.howtodoinjava.myfinder.delegate.MovieServiceDelegate;

@RestController
public class MovieServiceController {
	
	@Autowired
	MovieServiceDelegate movieServiceDelegate;

	@RequestMapping(value = "/getAllMovies", method = RequestMethod.GET)
	public String getAllMovies() {
		return MovieServiceDelegate.getAllFilmsDataFallback();
	}

	@RequestMapping(value = "/getAllActeurs", method = RequestMethod.GET)
	public String getAllActeurs() {
		return MovieServiceDelegate.getAllActeursDataFallback();
	}
	
}
