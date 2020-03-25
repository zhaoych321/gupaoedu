package org.example.state;


public class Input {

	public static enum Event {
		UP {
			@Override
			public boolean handleInput(StateMachine machine, Input in) {
				return machine.enterNewState(in, StateMachine.WALK);
			}
		},
		
		DOWN {
			@Override
			public boolean handleInput(StateMachine machine, Input in) {
				return machine.enterNewState(in, StateMachine.NULL);
			}
		},
		
		FLY {
			@Override
			public boolean handleInput(StateMachine machine, Input in) {
				return machine.enterNewState(in, StateMachine.FLY);

			}
		};
		
		public abstract boolean handleInput(StateMachine machine, Input in);
	}
}
