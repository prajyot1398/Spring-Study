package com.study.annotationspringconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.study.xmlspringconfig.Coach;
import com.study.xmlspringconfig.FortuneService;

@Component
public class BadmintonCoach implements Coach {
	
	private FortuneService fortuneService;
	private int coachAge;
	private String coachName;
	
	public BadmintonCoach() {
		System.out.println("Inside BadmintonCoach() Default Constructor");
	}
	
	@Override
	public String getInstructions() {
		return "Practice Badminton Service For 50 Mins And Then Practice Badminton Dual Match";
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside BadmintonCoach:setter of FortuneService");
		this.fortuneService = fortuneService;
	}

	public void setCoachAge(int coachAge) {
		this.coachAge = coachAge;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
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
