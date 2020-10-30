package com.event.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootConfiguration
public class Application implements ApplicationRunner{
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		eventPublisher.publishEvent(new DemoEvent("aaaaaaa", "aaaaaaa"));
	}
}
