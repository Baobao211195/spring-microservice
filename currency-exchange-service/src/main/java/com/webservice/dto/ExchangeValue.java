package com.webservice.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeValue {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMutiple;
	private int port;

}
