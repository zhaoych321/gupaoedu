package com.event.spring;

import org.springframework.context.ApplicationListener;

public class UserInsertListener implements ApplicationListener<UserRegisterEvent>{

	@Override
	public void onApplicationEvent(UserRegisterEvent event) {
		System.out.println("user insert listen！");
		
	}

}
