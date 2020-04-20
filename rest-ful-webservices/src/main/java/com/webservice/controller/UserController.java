package com.webservice.controller;

import java.net.URI;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.webservice.domain.Customer;
import com.webservice.dto.UserDto;
import com.webservice.exception.CustomException;
import com.webservice.page.ListResults;
import com.webservice.page.PaginatedResults;
import com.webservice.repository.CustomerRepository;
import com.webservice.service.CustomerService;

@RestController
public class UserController {
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private MessageSource messageSource;
	
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
	
	@RequestMapping(path = "/locale", method = RequestMethod.GET)
	@ResponseBody
	public String getLocale(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Customer getById(@PathVariable Integer id) {
		// call database
		
		Optional<Customer> custom =  repo.findById(id.longValue());
		
		custom.orElseThrow(() -> new CustomException("NOT FOUND"));
		
		return custom.get();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/user", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllCustomer(Pageable pageable, HttpServletRequest request) {
		// call database
		ListResults customer = customerService.getCustomer(pageable, request);
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
		uriBuilder.queryParam("page", pageable.getPageNumber());
		uriBuilder.queryParam("size", pageable.getPageSize());
		
		PaginatedResults<Customer> event = new PaginatedResults<Customer>(Customer.class, uriBuilder, customer, pageable, customer.getTotalPages());
		eventPublisher.publishEvent(event);
		return event.getPage();
		
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
