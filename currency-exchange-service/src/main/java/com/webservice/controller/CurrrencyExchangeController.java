package com.webservice.controller;

import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.dto.ExchangeValue;
import com.webservice.entity.CurrencyExchange;
import com.webservice.repository.CurrencyExchangeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CurrrencyExchangeController {
	
	private final Environment enviroment;
	private final CurrencyExchangeRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@ResponseBody
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) throws Exception {
		Optional<CurrencyExchange> exc = repo.findByFromAndTo(from, to);
		return exc.map(p -> {
			return ExchangeValue.builder()
				.id(p.getId())
				.from(p.getFrom()).to(p.getTo())
				.conversionMutiple(p.getConversionMutiple())
				.port(Integer.parseInt(enviroment.getProperty("local.server.port"))).build(); 
		}).orElseThrow(() ->new Exception("NOT FOUND DATA"));
		
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}")
	@ResponseBody
	public ExchangeValue retrieveExchangeValueFeign(@PathVariable String from, @PathVariable String to) throws Exception {
		Optional<CurrencyExchange> exc = repo.findByFromAndTo(from, to);
		return exc.map(p -> {
			return ExchangeValue.builder()
				.id(p.getId())
				.from(p.getFrom()).to(p.getTo())
				.conversionMutiple(p.getConversionMutiple())
				.port(Integer.parseInt(enviroment.getProperty("local.server.port"))).build(); 
		}).orElseThrow(() ->new Exception("NOT FOUND DATA"));
	}
}
