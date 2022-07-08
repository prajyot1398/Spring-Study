package com.study.xmlspringconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContextXML.xml");
		
		System.out.println("************* Normal Bean *************************");
		Coach coachObj = context.getBean("coachController", Coach.class);
		System.out.println("coachController : "+coachObj.getInstructions());
		System.out.println("coachController : "+coachObj.getFortune());
		System.out.println("coachController : "+coachObj.getCoachAge());
		System.out.println("coachController : "+coachObj.getCoachName());
		System.out.println("************* End Normal Bean *************************");
		
		System.out.println("****************** Bean Object Initialized Thro .proprties file **********************");
		//Object whose literal values are set from properties
		Coach objCoach = context.getBean("cricketCoachController", Coach.class);
		System.out.println("cricketCoachController : "+objCoach.getInstructions());
		System.out.println("cricketCoachController : "+objCoach.getFortune());
		System.out.println("cricketCoachController : "+objCoach.getCoachAge());
		System.out.println("cricketCoachController : "+objCoach.getCoachName());
		System.out.println("****************** End Bean Object Initialized Thro .proprties file **********************");
		
		System.out.println("************* Checking Bean Scope ********************");
		System.out.println("************* Singleton Bean *************************");
		((CricketCoach)coachObj).setCoachAge(102);
		System.out.println("coachObj : "+coachObj.getCoachAge());
		System.out.println("After Changing Age with setter and created new reference for bean");
		Coach newRefCoach = context.getBean("coachController", Coach.class);
		System.out.println("newRefCoach : "+newRefCoach.getCoachAge());
		System.out.println("coachObj == newRefCoach : " + (coachObj == newRefCoach));
		System.out.println("************* End Singleton Bean **********************");
		
		System.out.println("************* Prototype Bean **************************");
		
		CricketCoach protoBeanCoach_1 = context.getBean("prototypeCricketCoach",CricketCoach.class);
		CricketCoach protoBeanCoach_2 = context.getBean("prototypeCricketCoach",CricketCoach.class);
		System.out.println("protoBeanCoach_1 == protoBeanCoach_2 : " + (protoBeanCoach_1 == protoBeanCoach_2));
		System.out.println("protoBeanCoach_1 : "+protoBeanCoach_1);
		System.out.println("protoBeanCoach_2 : "+protoBeanCoach_2);
		System.out.println("************* End Prototype Bean **************************");
		
		context.close();
	}

}
