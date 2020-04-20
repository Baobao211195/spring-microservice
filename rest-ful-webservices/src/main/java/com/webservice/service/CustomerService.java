package com.webservice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Pageable;

import com.webservice.page.ListResults;

public interface CustomerService {
	
	ListResults getCustomer(Pageable page,  HttpServletRequest request);

}
