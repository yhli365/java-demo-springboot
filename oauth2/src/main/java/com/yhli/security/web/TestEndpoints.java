package com.yhli.security.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoints {
	private static final Logger log = LoggerFactory.getLogger(TestEndpoints.class);

	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable String id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.debug("getProduct# auth={}", authentication);
		return "product id : " + id;
	}

	@GetMapping("/order/{id}")
	public String getOrder(@PathVariable String id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.debug("getOrder# auth={}", authentication);
		return "order id : " + id;
	}

}
