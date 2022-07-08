package com.study.xmlspringconfig;

public class CricketCoach implements Coach {

	private String coachName;
	private FortuneService fortuneService;
	private int coachAge;
	
	public CricketCoach() {
		
	}
	
	private void initForBean() {
		System.out.println("Inside init called by ApplicationContext, though method is private");
	}
	
	//destroy method will be called by Spring Container.
	public void destroyBean() {
		System.out.println("Destroying Bean");
	}
	public CricketCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getCoachName() {
		return coachName;
	}
	
	//Used For Spring setter dependency injection
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	//Used For Spring setter dependency injection
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public int getCoachAge() {
		return coachAge;
	}
	
	//Used For Spring setter dependency injection
	public void setCoachAge(int coachAge) {
		this.coachAge = coachAge;
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortuneService();
	}
	
	@Override
	public String getInstructions() {
		return "Run 20 rounds, then 15 mins batting practice and 20 min fielding practice";
	}

}
