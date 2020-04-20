package com.webservice.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class UserDto {
	private Long id;
	private String firstName;
	private String lastName;
	
}
