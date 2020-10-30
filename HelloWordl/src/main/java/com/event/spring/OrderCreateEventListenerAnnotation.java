package com.event.spring;

import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;

@Component
public class OrderCreateEventListenerAnnotation {
	
	@EventListener(OrderCreateEvent.class)
	public void orderCreateEvent() {
		System.out.println("========orderCreateEvent======");
	}
}
