package com.event.spring;

import org.springframework.context.ApplicationListener;

public class NotifyUserListener implements ApplicationListener<UserRegisterEvent>{

	@Override
	public void onApplicationEvent(UserRegisterEvent event) {
		System.out.println("notify user listen！");
		
	}

}
