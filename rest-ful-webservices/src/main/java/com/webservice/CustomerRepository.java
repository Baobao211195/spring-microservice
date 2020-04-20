package com.webservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("select c from Customer c")
	Page<Customer> getCustomer(Pageable page);
}
