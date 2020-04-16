package com.webservice.dto;

import java.util.Date;

import javax.validation.constraints.Size;

public class UserDto {
	private Integer id;
	
	@Size(min = 4, message = "Hello validation")
	private String name;
	
	private Date birthDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
