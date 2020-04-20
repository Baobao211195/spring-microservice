package com.webservice.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginatedResults<T extends Serializable> extends ApplicationEvent {
	private static final long serialVersionUID = 4459105497710754062L;
	private final UriComponentsBuilder uriBuilder;
	private Pageable pagable;
	private Page<T> page;
	private HttpServletRequest request;
	private final int totalPages;

	public PaginatedResults(final Class<T> clazz, final UriComponentsBuilder uriBuilderToSet, final Page<T> pageToSet,
			final Pageable pageableToSet, final int totalPagesToSet) {
		super(clazz);
		uriBuilder = uriBuilderToSet;
		pagable = pageableToSet;
		page = pageToSet;
		totalPages = totalPagesToSet;
	}

	public final UriComponentsBuilder getUriBuilder() {
		return uriBuilder;
	}

	public final HttpServletRequest getRequest() {
		return request;
	}

	public final int getTotalPages() {
		return totalPages;
	}

	public Pageable getPagable() {
		return pagable;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPagable(Pageable pagable) {
		this.pagable = pagable;
	}

	/**
	 * The object on which the Event initially occurred.
	 * 
	 * @return The object on which the Event initially occurred.
	 */
	@SuppressWarnings("unchecked")
	public final Class<T> getClazz() {
		return (Class<T>) getSource();
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}
}