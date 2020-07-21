package com.luv2code.springdemo;

public class SwimCoach implements Coach {
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 5 breaststroke\n" + "Swim 5 backstroke\n"+
	"Swim 5 butterfly";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
}
