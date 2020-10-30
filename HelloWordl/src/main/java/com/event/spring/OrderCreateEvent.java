package com.event.spring;

import org.springframework.context.ApplicationEvent;


public class OrderCreateEvent extends ApplicationEvent {

	public OrderCreateEvent(Object source) {
		super(source);
	}

}
