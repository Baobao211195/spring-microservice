package com.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2134490306198687997L;

	public CustomException(String message) {
		super(message);
	}

}
