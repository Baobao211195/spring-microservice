package com.webservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CURRENCY_EXCHANGE")
public class CurrencyExchange {
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "FROM_VALUE", nullable = false)
	private String from;
	
	@Column(name = "TO_VALUE", nullable = false)
	private String to;
	
	@Column(name = "CONVERSION_MULTIPLE", nullable = false)
	private BigDecimal conversionMutiple;
	
	
	@Column(name = "PORT", nullable = false)
	private int port;
}
