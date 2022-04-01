package com.worthen.cody.dependencyinjection.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.worthen.cody.dependencyinjection.services.ConstructorGreetingService;

// BEST WAY TO INJECT DEPENDENCIES (THRU THE CONSTRUCTOR)

class ConstructorInjectedControllerTest {

	ConstructorInjectedController controller;

	@BeforeEach
	void setUp() {
		controller = new ConstructorInjectedController(new ConstructorGreetingService());
	}

	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}

}
