package com.luv2code.springdemo;

public class Trackcoach implements Coach {
	
	public Trackcoach() {
		
	}
	// define a private field for the dependency
	private FortuneService fortuneService;

	public Trackcoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just Do It:" +fortuneService.getFortune();
	}
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	//add a destroy method
	public void doMyDestroyStuff() {
		System.out.println("TrackCoach: inside method doMyDestroyStuff");
	}
	
}
