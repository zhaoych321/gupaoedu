package org.example;

import com.google.common.eventbus.EventBus;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EventBus eventBus = new EventBus();
        eventBus.register(new Teacher("Tom"));
        eventBus.register(new Teacher("Jerry"));

        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");
        eventBus.post(question);
    }
}
