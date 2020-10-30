package com.event.spring;

import org.springframework.context.ApplicationListener;

public class RecommendListener implements ApplicationListener<UserRegisterEvent>{
	@Override
	public void onApplicationEvent(UserRegisterEvent event) {
		System.out.println("recommend listen！");
		
	}
}
