package myspring.di.xml;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class HelloJUnit5Test {
	ApplicationContext context;
	
	@BeforeEach
	void createContainer() {		
		//1. Container 객체생성
		context = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}
	
	@Test	
	void helloBean() {				
		//1. Container 객체생성		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:spring-beans.xml");	
		
		Hello helloById = (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		
		System.out.println(helloById == helloByType);
		Assertions.assertSame(helloById, helloByType);
		assertSame(helloById, helloByType);
		
		assertEquals("Hello 스프링", helloByType.sayHello());

		helloByType.print();
		
		Printer printer = context.getBean("stringPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}
}
