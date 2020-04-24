package com.webservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url = "localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="zuul-api-gateway", url = "localhost:8765") // use name of API gateway server
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	/**
	 * @param from
	 * @param to
	 * @param quantity
	 * @return
	 */
	//@GetMapping("/currency-converter-feign/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-converter-feign/from/{from}/to/{to}") // forward request from api gateway to service use name of API gateway server
	public Object convertCurrency(
			@PathVariable String from,
			@PathVariable String to);

}
