package com.study.annotationspringconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.study.xmlspringconfig.Coach;
import com.study.xmlspringconfig.FortuneService;

@Component("tennisCoachBean")
@Scope("prototype")
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${coach.age}")	//Field Injection
	private int coachAge;
	@Value("${coach.name}")
	private String coachName;
	
	@Autowired
	public TennisCoach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public void setCoachAge(int coachAge) {
		this.coachAge = coachAge;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	@Override
	public String getInstructions() {
		return "Practice Tennis Service For 50 Mins And Then Practice Dual Match";
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
