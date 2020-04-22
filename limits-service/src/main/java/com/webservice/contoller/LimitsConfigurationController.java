package com.webservice.contoller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.dto.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@RequestMapping(path = "/limits", method = RequestMethod.GET)
	@ResponseBody
	public LimitsConfiguration retrieveLimitsFromConfiguration() {
		return new LimitsConfiguration();
	}
}
