package com.worthen.cody.dependencyinjection.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.worthen.cody.dependencyinjection.services.I18nSpanishGreetingService;

public class I18nControllerTest {

	I18nController i18nController;

	@BeforeEach
	void setUP() {
		i18nController = new I18nController(new I18nSpanishGreetingService());
	}

	@Test
	void sayHello() {
		System.out.println(i18nController.sayHello());
	}

}
