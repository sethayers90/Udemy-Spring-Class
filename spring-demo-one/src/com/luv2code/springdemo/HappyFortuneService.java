package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {
	private String [] data = {
			"Be a champion today",
			"Just do it",
			"Be better than yesterday"
	};
	
	private Random myRandom = new Random();
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		return theFortune ;
		
	}

}
