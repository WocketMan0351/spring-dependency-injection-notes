package com.worthen.cody.dependencyinjection.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

// BEST WAY TO INJECT DEPENDENCIES

import com.worthen.cody.dependencyinjection.services.GreetingService;

@Controller
public class ConstructorInjectedController {

	// @Primary can be used to define a default bean when multiple types are present
	// and can be specified in the
	// @Qualifier annotation of whatever aggregates it.

	// @Qualifier takes precedence over @Primary

	// @Qualifier can be whatever you specify, but the default name is the leading
	// lower case version of the class name. In this case, the class that has the
	// bean of type GreetingService is ConstructorInjectedService, so the qualifier
	// name we use here is constructorInjectedService.

	private final GreetingService greetingService; // this should never change

	public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String getGreeting() {
		return greetingService.sayGreeting();
	}

}
