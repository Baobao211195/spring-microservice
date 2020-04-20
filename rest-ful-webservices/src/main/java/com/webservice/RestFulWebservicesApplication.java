package com.webservice;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservice.domain.Customer;
import com.webservice.dto.UserDto;
import com.webservice.exception.CustomException;

@SpringBootApplication
@RestController
public class RestFulWebservicesApplication {
	
	@Autowired
	private CustomerRepository repo;
	
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
	
	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserDto getById(@PathVariable Integer id) {
		// call database
		return new UserDto();
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	@ResponseBody
	public URI save(@Valid @RequestBody UserDto object) {
		// insert into database
		Customer cus = new Customer(object);
		Customer cusEntity = repo.save(cus);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cusEntity.getId()).toUri();
		return location;
	}

}
