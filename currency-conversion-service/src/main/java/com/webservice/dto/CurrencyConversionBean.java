package com.webservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CurrencyConversionBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7884755280222192126L;
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
//	private BigDecimal quantity;
//	private BigDecimal totalCalculatedAmount;
	private int port;
}
