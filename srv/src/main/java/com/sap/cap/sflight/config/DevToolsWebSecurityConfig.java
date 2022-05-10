package com.sap.cap.sflight.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(1)
@Profile("devtools")
public class DevToolsWebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String SPRING_BOOT_DEVTOOLS_ENDPOINT = "/.~~spring-boot!~/**";
	private static final Logger logger = LoggerFactory.getLogger(DevToolsWebSecurityConfig.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers() //
				.antMatchers(SPRING_BOOT_DEVTOOLS_ENDPOINT) //
				.and().csrf().disable().authorizeRequests().anyRequest().permitAll();

				logger.info("running with remote-devtool support enabled. opening up specific endpoints.");
	}
}
