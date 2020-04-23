package com.webservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeValue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4517212486792991516L;
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMutiple;
	private int port;

}
