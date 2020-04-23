package com.webservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
	
	/**
	 * @param from
	 * @param to
	 * @param quantity
	 * @return
	 */
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}")
	public Object convertCurrency(
			@PathVariable String from,
			@PathVariable String to);

}
