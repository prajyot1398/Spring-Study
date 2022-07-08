package com.study.javaspringconfig;

import com.study.xmlspringconfig.Coach;
import com.study.xmlspringconfig.FortuneService;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	private int coachAge;
	private String coachName;
	
	public SwimCoach(FortuneService fortuneService, int age, String name) {
		this.fortuneService = fortuneService;
		this.coachAge = age;
		this.coachName = name;
	}
	
	@Override
	public String getInstructions() {
		return "Swim in 400 Metres Pool For 80 Mins And The Sprint For 100 Meters";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortuneService();
	}

	@Override
	public int getCoachAge() {
		return coachAge;
	}

	@Override
	public String getCoachName() {
		return coachName;
	}

}
