package com.event.spring;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

	private String message;
	
	public DemoEvent(Object source, String message) {
		super(source);
		this.message = message;
	}
}
