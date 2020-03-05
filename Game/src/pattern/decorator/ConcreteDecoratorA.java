package pattern.decorator;

public class ConcreteDecoratorA extends Decorator {
	private String addedState;

	@Override
	public void operation() {
		super.operation();
		addedState = "New State";
		System.out.println("����װ�ζ���A�Ĳ���");
	}
}
