package com.worthen.cody.dependencyinjection.controllers;

import org.springframework.stereotype.Component;

import com.worthen.cody.dependencyinjection.services.GreetingService;

@Component
public class PrimaryGreetingServiceController {

	// Notice there is a lack of a @Qualifier here, so Spring doesn't know what bean
	// of GreetingService to grab.

	// We fix this by annotating the primary bean, PrimaryGreetingService in this
	// case, with the @Primary annotation.

	// The primary bean will be automatically injected anytime we fail to include
	// the @Qualifier annotation.

	private final GreetingService greetingService;

	public PrimaryGreetingServiceController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayGreeting() {
		return greetingService.sayGreeting();

	}

}
