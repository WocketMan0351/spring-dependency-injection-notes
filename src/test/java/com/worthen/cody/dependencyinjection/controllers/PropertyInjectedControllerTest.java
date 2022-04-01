package com.worthen.cody.dependencyinjection.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.worthen.cody.dependencyinjection.services.ConstructorGreetingService;

// LEAST PREFERRED METHOD TO INJECT DEPENDENCIES
// WE DON'T WANT TO INJECT DEPENDENCIES DIRECTLY ON PROPERTIES

class PropertyInjectedControllerTest {

	PropertyInjectedController controller;

	@BeforeEach
	void setUp() {
		controller = new PropertyInjectedController();
		controller.greetingService = new ConstructorGreetingService();
	}

	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}

}
