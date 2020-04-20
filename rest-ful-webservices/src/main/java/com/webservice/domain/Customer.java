package com.webservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.webservice.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Entity
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5777426607519180456L;

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
