package org.example.state;

public final class NullState implements IState {

	private NullState() {}
	
	public static IState create() {
		return new NullState();
	}
	
	@Override
	public boolean enter(Input in) {
		System.out.println("enter null state！");
		return true;
	}

	@Override
	public boolean exit(Input in) {
		System.out.println("exit null state！");
		return true;
	}

	@Override
	public int toInt() {
		return ZuoqiState.NULL;
	}

}
