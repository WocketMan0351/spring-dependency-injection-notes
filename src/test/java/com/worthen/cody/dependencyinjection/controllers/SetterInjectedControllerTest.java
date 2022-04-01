package com.worthen.cody.dependencyinjection.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.worthen.cody.dependencyinjection.services.ConstructorGreetingService;

// MORE PREFERRED THAN PROPERTY INJECTED DEPENDENCIES
// WE ARE INJECTING DEPENDENCIES WITH SETTERS

class SetterInjectedControllerTest {

	SetterInjectedController controller;

	@BeforeEach
	void setUp() {
		controller = new SetterInjectedController();
		controller.setGreetingService(new ConstructorGreetingService());
	}

	@Test
	void testGetGreeting() {
		System.out.println(controller.getGreeting());
	}

}
