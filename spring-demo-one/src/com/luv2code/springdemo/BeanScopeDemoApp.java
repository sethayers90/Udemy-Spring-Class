package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//Load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext
				("beanScope-applicationContext.xml");
		
		
		//Retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach" , Coach.class);
		Coach alphaCoach = context.getBean("myCoach" , Coach.class);
		
		//check if they are the same 
		boolean result = (theCoach == alphaCoach);
		System.out.println("Point to the same object" +"\n" + result);
		
		System.out.println("\nMemory location for theCoach" + theCoach);
		
		System.out.println("\nMemory location for alphaCoach" + alphaCoach);
		
		context.close();
	}

}
