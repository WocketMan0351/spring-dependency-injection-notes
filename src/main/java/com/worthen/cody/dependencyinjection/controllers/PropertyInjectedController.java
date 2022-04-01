package com.worthen.cody.dependencyinjection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.worthen.cody.dependencyinjection.services.GreetingService;

// WORST WAY

@Controller
public class PropertyInjectedController {

	// @Primary can be used to define a default bean when multiple types are present
	// and can be specified in the
	// @Qualifier annotation of whatever aggregates it.

	// @Qualifier takes precedence over @Primary

	// @Qualifier can be whatever you specify, but the default name is the leading
	// lower case version of the class name. In this case, the class that has the
	// bean
	// of type GreetingService is PropertyInjectedService, so the qualifier name we
	// use here is propertyInjectedService.

	@Qualifier("propertyInjectedGreetingService")
	@Autowired
	public GreetingService greetingService;

	public String getGreeting() {
		return greetingService.sayGreeting();
	}

}
