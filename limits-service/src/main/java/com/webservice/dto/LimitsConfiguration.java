package com.webservice.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("limit-serivce")
public class LimitsConfiguration {
	private int maximum;
	private int minimum;
}
