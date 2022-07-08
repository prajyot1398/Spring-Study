package com.study.annotationspringconfig;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.study.xmlspringconfig.Coach;
import com.study.xmlspringconfig.FortuneService;

@Component
public class BasketBallCoach implements Coach {

	@Autowired	//Field Injection
	@Qualifier("sadFortuneService") 
	private FortuneService fortuneService;
	
	private int coachAge;
	private String coachName;
	
	@PostConstruct
	public void init() {
		System.out.println("PostConstruct Method For BasketBall Bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("PreDestroy Method For BasketBall Bean");
	}
	
	@Override
	public String getInstructions() {
		return "Practice 3 Points And Troubling For 50 Mins Each";
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
