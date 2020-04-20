package com.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.webservice.dto.UserDto;

import lombok.Data;

@Data
@Table(name = "customer")
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name= "first_name")
	private String fistName;
	
	@Column(name= "last_name")
	private String lastName;
	
	public Customer (UserDto userDto) {
		this.id = userDto.getId();
		this.fistName = userDto.getFirstName();
		this.lastName = userDto.getLastName();
	}
	
}
