package com.study.javaspringconfig;

import java.beans.BeanProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.study.logger.MyLoggerConfig;
import com.study.xmlspringconfig.Coach;
import com.study.xmlspringconfig.FortuneService;
import com.study.xmlspringconfig.HappyFortuneService;

@Configuration
//@ComponentScan("com.study.xmlspringconfig") //If single package is used.
//Multiple Packages To Be Added In ComponentScan
@ComponentScan({"com.study.xmlspringconfig", "com.study.annotationspringconfig"})
@PropertySource({"classpath:sports.properties","classpath:logger.properties"})
public class SportsConfig {
	
	//Package For MyLoggerConfig is not added in ComponentScanning therefore using @Bean annotation
	//Bean is created and dependencies injected
	@Bean
	public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}")String rootLoggerLevel,
			@Value("${printed.logger.level}") String printedLoggerLevel) {
		MyLoggerConfig myLoggerConfig = new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
		return myLoggerConfig;
	}
	
	@Bean
	public FortuneService happyFortuneService() {
		System.out.println("Creating The HappyFortuneService object");
		return new HappyFortuneService();
	}
	
	@Bean
	//@Scope("prototype")
	public Coach swimCoach() {
		Coach coachBean = new SwimCoach(happyFortuneService(), 45, "Michel Philip");
		return coachBean;
	}
}	
