package com.webservice.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.dto.ExchangeValue;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CurrrencyExchangeController {
	
	private final Environment enviroment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		return ExchangeValue.builder().from(from).to(to).port(Integer.parseInt(enviroment.getProperty("local.server.port"))).build();		
	}
}
