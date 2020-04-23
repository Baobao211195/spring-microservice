package com.webservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.webservice.service.CurrencyExchangeServiceProxy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CurrencyConversionController {
	
	
	private final RestTemplate restTemplate;
	private final CurrencyExchangeServiceProxy crProxy;
	
	
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
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}")
	@ResponseBody
	public Object convertCurrencyUseFeign(@PathVariable String from,
			 @PathVariable String to) {
		
		Object cvbF = crProxy.convertCurrency(from, to);
		return cvbF;
		
	}

}
