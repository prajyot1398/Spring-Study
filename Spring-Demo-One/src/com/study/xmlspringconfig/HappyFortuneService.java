package com.study.xmlspringconfig;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	public HappyFortuneService() {
		System.out.println("In HappyFortuneService Constructor");
	}
	@Override
	public String getFortuneService() {
		
		String[] fortunes = new String[]{"Work Hard And Go Ahead.","Play Hard And Earn Name","70 Mins"};
		return fortunes[new Random().nextInt(3)];	
	}

}
