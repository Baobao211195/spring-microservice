package com.webservice.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfiguration {
	
	@Bean
	public SessionLocaleResolver localResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource bundleMessageSource()  {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	
}
