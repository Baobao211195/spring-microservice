package com.webservice.exception;

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

}
