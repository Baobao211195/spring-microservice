package com.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.exception.CustomException;

@SpringBootApplication
@RestController
public class RestFulWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFulWebservicesApplication.class, args);
	}
	
	@RequestMapping(path = "/name", method = RequestMethod.GET)
	@ResponseBody
	public String getName() {
		return "Oanh";
	}
	
	@RequestMapping(path = "/exception", method = RequestMethod.GET)
	@ResponseBody
	public String getException() {
		if (true) {
			throw new CustomException("Custom Exception");
		}
		return "Oanh";
	}

}
