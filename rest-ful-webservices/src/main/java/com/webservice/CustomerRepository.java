package com.webservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
