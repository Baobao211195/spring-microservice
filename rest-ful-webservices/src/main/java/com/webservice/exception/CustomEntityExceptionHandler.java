package com.webservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public final ExceptionResponse handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse er = new ExceptionResponse();
		return er;
	}
	@ExceptionHandler(CustomException.class)
	@ResponseBody
	public final ExceptionResponse handleCustomException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse er = new ExceptionResponse();
		return er;
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse er = new ExceptionResponse();
		er.setTimeStamp(new Date());
		er.setMessage(ex.getMessage());
		er.setDetails(ex.getBindingResult().toString());
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}
}
