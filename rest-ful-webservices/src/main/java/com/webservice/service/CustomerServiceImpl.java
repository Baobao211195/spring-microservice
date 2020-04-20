package com.webservice.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.webservice.CustomerRepository;
import com.webservice.domain.Customer;
import com.webservice.dto.ListResults;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public ListResults getCustomer(Pageable page,  HttpServletRequest request) {
		ListResults lr = null;
		
		Page<Customer> customer = customerRepository.getCustomer(page);
		
		if (!customer.hasContent()) {
			lr = new ListResults(new ArrayList<>(), request, page, 0);
			lr.setHttpStatus(HttpStatus.NO_CONTENT.name());
			return  lr;
		}
		
		lr = new ListResults(customer.getContent(), request, page, customer.getTotalElements());
		lr.setHttpStatus(HttpStatus.OK.toString());
		return lr;
		
	}

}
