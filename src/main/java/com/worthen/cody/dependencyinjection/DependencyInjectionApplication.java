package com.worthen.cody.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.worthen.cody.dependencyinjection.controllers.ConstructorInjectedController;
import com.worthen.cody.dependencyinjection.controllers.I18nController;
import com.worthen.cody.dependencyinjection.controllers.PrimaryGreetingServiceController;
import com.worthen.cody.dependencyinjection.controllers.PropertyInjectedController;
import com.worthen.cody.dependencyinjection.controllers.SetterInjectedController;

// This project shows how dependency injection can be manually performed thru a JUnit test.

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DependencyInjectionApplication.class, args);
		System.out.println();

		// COMMON ERRORS

		/**
		 * PropertyInjectedController -- throws NoSuchBeanDefinitionException
		 * 
		 * 1) We fix the NoSuchBeanDefinitionException by annotating the class
		 * PropertyInjectedController with @Controller. This now throws a
		 * NullPointerException.
		 * 
		 * 2) The NullPointerException is fixed by annotating the
		 * PropertyInjectedController property of GreetingService with @AutoWired. This
		 * tells spring to use the property for the dependency.
		 */
		System.out.println("------- Property Injected Controller --------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) applicationContext
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
		System.out.println();

		/**
		 * SetterInjectedController -- throws throws NoSuchBeanDefinitionException
		 * 
		 * 1) We fix the NoSuchBeanDefinitionException by annotating the class
		 * SetterInjectedController with @Controller. This now throws a
		 * NullPointerException.
		 * 
		 * 2) The NullPointerException is fixed by annotating the setter method
		 * setGreetingService() with @Autowired. This tells spring to use the setter for
		 * the dependency.
		 * 
		 */
		System.out.println("------- Setter Injected Controller -------");
		SetterInjectedController setterInjectedController = (SetterInjectedController) applicationContext
				.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		System.out.println();

		/**
		 * ConstructorInjectedController -- throws throws NoSuchBeanDefinitionException
		 * 
		 * 1) We fix the NoSuchBeanDefinitionException by annotating the class
		 * ConstructorInjectedController with @Controller.
		 * 
		 * 2) Spring now automatically detects the dependency and we are no longer
		 * required to annotate it with @Autowired
		 */
		System.out.println("------- Constructor Injected Controller -------");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) applicationContext
				.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
		System.out.println();

		/**
		 * PrimaryGreetingService is annotated with @Primary, which is the default bean
		 * we will grab for GreetingService in the absence of a @Qualifier.
		 */
		System.out.println("------ Primary Bean ------");
		PrimaryGreetingServiceController primaryGreetingServiceController = (PrimaryGreetingServiceController) applicationContext
				.getBean("primaryGreetingServiceController");
		System.out.println(primaryGreetingServiceController.sayGreeting());
		System.out.println();

		/**
		 * I18nController is using a ConstructorInjectedController and
		 * a @Qualifier("i18nController).
		 * 
		 * However, two classes share this same @Qualifier("i18nController) annotation.
		 * We want to use different classes depending on our environment (such as
		 * development vs production environments).
		 * 
		 * Thus, we have added a @Primary("ES") annotation to I18nEnglishGreetingService
		 * and a @Primary("ES") annotation to I18nSpanishGreetingService to distinguish
		 * which one we want to use.
		 * 
		 * We set this property in our application.properties file by specifying
		 * spring.profiles.active=EN so Spring knows which profile we wish to use.
		 * 
		 * Either an active profile or a default profile is required (if no active
		 * profile is set). The default is annotated by passing an array into
		 * the @Primary like so: @Primary({"EN", default})
		 * 
		 * Multiple profiles can be active at once, just add a comma between them (no
		 * space)
		 */
		System.out.println("------ Spring Profiles ------");
		I18nController i18nController = (I18nController) applicationContext.getBean("i18nController");
		System.out.println(i18nController.sayHello());
		System.out.println();

		// SPRING BEAN LIFECYCLE

		/**
		 * 1) Instantiate
		 * 
		 * 2) Populate Properties
		 * 
		 * 3) Call setBeanName of BeanNameAware
		 * 
		 * 4) Call setBeanFactory of BeanFactoryAware
		 * 
		 * 5) Call setApplicationContext of ApplicationContextAware
		 * 
		 * 6) Preinitialization (Bean PostProcessors)
		 * 
		 * 7) afterPropertiesSet of Initializing Beans
		 * 
		 * 8) Custom Init Method
		 * 
		 * 9) Post Initialization (BeanPostProcessors)
		 * 
		 * 10) Bean Ready to Use
		 * 
		 * [SOME TYPE OF TERMINATION EVENT]
		 * 
		 * 11) Container Shutdown
		 * 
		 * 12) Disposable Bean's destroy() -- Spring has 2 interfaces you can implement
		 * for CALL BACK EVENTS (optional):
		 * 
		 * *** 1) InitializingBean.afterPropertiesSet() *** --- called after properties
		 * are set
		 * 
		 * *** 2) DisposableBean.destroy() *** --- called during bean destruction in
		 * shutdown
		 * 
		 * 13) Call Custom Destroy Method
		 */

		// LIFE CYCLE ANNOTATIONS

		/**
		 * Spring has 2 annotations we can use to hook into the bean life cycle:
		 * 
		 * 1) @PostConstruct annotated methods will be called after the bean has been
		 * constructed, but before its returned to the requesting object.
		 * 
		 * 2) @PreDestory is called just before the bean is destroyed by the container.
		 */

		// BEAN POST PROCESSORS (probably won't use)

		/**
		 * Gives you a means to tap into the Spring context life cycle and interact with
		 * beans as they are processed.
		 * 
		 * Implement interface BeanPostProcessor:
		 * 
		 * --- postProcessBeforeInitialization - called before bean initialization
		 * method
		 * 
		 * --- postProcessAfterInitialization - called after bean initialization
		 */

		// SPRING AWARE INTERFACES

		/**
		 * Spring has over 14 "AWARE" INTERFACES
		 * 
		 * These are used to access the Spring Framework infrastructure. These are
		 * largely used within the framework and rarely used by developers.
		 */
	}

}
