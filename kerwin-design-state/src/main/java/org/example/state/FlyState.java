package org.example.state;

public class FlyState implements IState {

	protected FlyState() {}
	
	public static IState create() {
		return new FlyState();
	}
	
	@Override
	public boolean enter(Input in) {
		System.out.println("enter fly state！");
		return true;
	}

	@Override
	public boolean exit(Input in) {
		System.out.println("exit fly state！");
		return true;
	}

	@Override
	public int toInt() {
		return ZuoqiState.Fly;
	}

}
