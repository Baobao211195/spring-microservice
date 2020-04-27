package com.webservice.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.webservice.dto.LimitsConfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
public class LimitsConfigurationController {
	
	@Autowired private LimitsConfiguration cofig;
	
	@RequestMapping(path = "/limits", method = RequestMethod.GET)
	@ResponseBody
	public Config retrieveLimitsFromConfiguration() {
		return new Config(cofig.getMaximum(), cofig.getMinimum());
	}
	
	@RequestMapping(path = "/faults", method = RequestMethod.GET)
	@ResponseBody
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	public Config retrieveHystrix() {
		throw new RuntimeException("Has exception");
	}
	
	public Config fallBackMethod() {
		return new Config(111, 222);
	}
	
	
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Config {
	private int maximum;
	private int minimum;
}
