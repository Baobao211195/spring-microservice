package com.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
