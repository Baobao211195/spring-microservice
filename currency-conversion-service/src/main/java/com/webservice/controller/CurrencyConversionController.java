package com.webservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CurrencyConversionController {
	
	
	@Autowired
	private  RestTemplate restTemplate;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	@ResponseBody
	public Object convertCurrency(@PathVariable String from,
												 @PathVariable String to,
												 @PathVariable BigDecimal quantity) {
		
		// create path variable
		Map<String, String> mapVariables = new HashMap<>();
		
		mapVariables.put("from", from);
		mapVariables.put("to", to);
		
		ResponseEntity<Object> currencyExchange = 
				restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
						Object.class, mapVariables);
		
		Object cvB = currencyExchange.getBody();
		
		return cvB;
//		return CurrencyConversionBean.builder()
//				.from(cvB.getFrom())
//				.to(cvB.getTo())
//				.conversionMultiple(cvB.getConversionMultiple())
//				.port(cvB.getPort())
//				.build();
	}
}
