package com.webservice.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings("rawtypes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResults extends PageImpl {
	private static final long serialVersionUID = 7663024066679759694L;
	String httpStatus;
//	String statusMessage;
	String url;
	
	@SuppressWarnings("unchecked")
	public ListResults(List content) {
		super(content);
		setHttpStatus(HttpStatus.OK.toString());
		setUrl("");
	}
	public ListResults(List content, HttpServletRequest req) {
		this(content);
		setUrl(req.getRequestURL().toString());
	}
	@SuppressWarnings("unchecked")
	public ListResults(List content, HttpServletRequest req, Pageable pageable, long totalSize) {
		super(content, pageable, totalSize);
		setUrl(req.getRequestURL().toString());
	}
	
	
	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
