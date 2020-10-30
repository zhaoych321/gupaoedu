package com.event.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationListener {
	@EventListener(value = {ContextRefreshedEvent.class, ContextStartedEvent.class, ContextStoppedEvent.class, ContextClosedEvent.class})
    public void listener(ApplicationEvent event) {
        System.out.println(Thread.currentThread() + " 接收到 Spring 事件：" + event);
    }
}
