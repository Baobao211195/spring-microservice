package com.webservice.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Config {
	private int maximum;
	private int minimum;
}
