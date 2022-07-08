package com.study.javaspringconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.xmlspringconfig.Coach;

public class JavaConfigMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportsConfig.class);
		
		System.out.println("\n************* Normal prototype Bean With Explicit Component Name/ID (Constructor Injection) *************************");
		Coach coachObj = context.getBean("tennisCoachBean", Coach.class);
		System.out.println("tennisCoachBean : "+coachObj.getInstructions());
		System.out.println("tennisCoachBean : "+coachObj.getFortune());
		System.out.println("tennisCoachBean : "+coachObj.getCoachAge());
		System.out.println("tennisCoachBean : "+coachObj.getCoachName());
		Coach tennisCoach = context.getBean("tennisCoachBean", Coach.class);
		System.out.println("tennisCoach_1 == tennisCoach_2 : "+(coachObj == tennisCoach));
		System.out.println("tennisCoach_1 : "+coachObj);
		System.out.println("tennisCoach_2 : "+tennisCoach);
		System.out.println("************* End Normal Bean *************************");
		
		System.out.println("\n************* Normal singleton Bean With Default Component Name/ID and Setter Dependency Injection *************************");
		Coach badmCoachObj = context.getBean("badmintonCoach", Coach.class);
		System.out.println("badmintonCoach : "+badmCoachObj.getInstructions());
		System.out.println("badmintonCoach : "+badmCoachObj.getFortune());
		//System.out.println("badmintonCoach : "+badmCoachObj.getCoachAge());
		//System.out.println("badmintonCoach : "+badmCoachObj.getCoachName());
		Coach badmCoach = context.getBean("badmintonCoach", Coach.class);
		System.out.println("badmCoach_1 == badmCoach_2 : "+(badmCoachObj == badmCoach));
		System.out.println("badmCoach_1 : "+badmCoachObj);
		System.out.println("badmCoach_2 : "+badmCoach);
		System.out.println("************* End Normal Bean *************************");
		
		System.out.println("\n************* Normal Bean With Default Component Name/ID and Field Injection *************************");
		Coach basketBallCoachObj = context.getBean("basketBallCoach", Coach.class);
		System.out.println("basketBallCoachObj : "+basketBallCoachObj.getInstructions());
		System.out.println("basketBallCoachObj : "+basketBallCoachObj.getFortune());
		//System.out.println("basketBallCoachObj : "+basketBallCoachObj.getCoachAge());
		//System.out.println("basketBallCoachObj : "+basketBallCoachObj.getCoachName());
		System.out.println("************* End Normal Bean *************************");
		
		System.out.println("\n************* Normal Bean With Configured Using Java Configuration With @Bean *************************");
		Coach swimCoach = context.getBean("swimCoach", Coach.class);
		System.out.println("swimCoach : "+swimCoach.getInstructions());
		System.out.println("swimCoach : "+swimCoach.getFortune());
		System.out.println("swimCoach : "+swimCoach.getCoachAge());
		System.out.println("swimCoach : "+swimCoach.getCoachName());
		Coach swimCoach2 = context.getBean("swimCoach",Coach.class);
		System.out.println("swimCoach == swimCoach2 : "+(swimCoach == swimCoach2));
		System.out.println("************* End Normal Bean *************************");
		
		
		context.close();
	}

}
