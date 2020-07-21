package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	public FootballCoach() {
		System.out.println(">> Football Coach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice tackling";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}


}
