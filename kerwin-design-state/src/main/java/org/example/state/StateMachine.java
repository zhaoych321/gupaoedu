package org.example.state;

public class StateMachine {
	
	public static final IState NULL = NullState.create();
	public static final IState WALK = WalkState.create();
	public static final IState FLY = FlyState.create();
	
	private IState cur = NULL;
	
	public StateMachine() {
	}
	
	public StateMachine(IState init) {
		this.cur = init;
	}
	
	public boolean input(Input.Event evt, Input in) {
		return evt.handleInput(this, in);
	}
	
	boolean enterNewState(Input in, IState newState) {
		if (!cur.exit(in)) {
			return false;
		}
		
		cur = newState;
		
		return cur.enter(in);
	}
}
