package org.example;

import org.example.state.Input;
import org.example.state.StateMachine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StateMachine stateMachine = new StateMachine(StateMachine.NULL);
        stateMachine.input(Input.Event.UP, new Input());
        stateMachine.input(Input.Event.FLY, new Input());
    }
}
