package com.webservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.dto.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
												 @PathVariable String to,
												 @PathVariable BigDecimal quantity) {
		
		return CurrencyConversionBean.builder().from(from).to(to).quantity(quantity).build();
	}
}
