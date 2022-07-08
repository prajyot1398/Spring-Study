package com.study.annotationspringconfig;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.study.xmlspringconfig.FortuneService;

@Component
public class SadFortuneService implements FortuneService {

	@Override
	public String getFortuneService() {
		String[] fortunes = new String[]{"You Are Loser","You Never Gonna Win","You Are Not Good"};
		return fortunes[new Random().nextInt(3)];	
	}
}
