package org.example.state;

public class WalkState implements IState {
	
	private WalkState() {}
	
	public static IState create() {
		return new WalkState();
	}

	@Override
	public boolean enter(Input in) {
		System.out.println("enter walk state！");
		return true;
	}

	@Override
	public boolean exit(Input in) {
		System.out.println("exit walk state！");
		return true;
	}

	@Override
	public int toInt() {
		return ZuoqiState.WALK;
	}

}
