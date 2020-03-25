package org.example.state;

public interface IState {
	int toInt();
	boolean enter(Input in);
	boolean exit(Input in);
}
