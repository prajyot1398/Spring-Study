package com.study.annotationspringconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.xmlspringconfig.Coach;

public class AnnotationConfigMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContextAnnotaion.xml");
	 	
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
		
		
		context.close();
	}
}
