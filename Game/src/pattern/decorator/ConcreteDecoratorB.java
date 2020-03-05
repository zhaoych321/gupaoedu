package pattern.decorator;

public class ConcreteDecoratorB extends Decorator {

	@Override
	public void operation() {
		super.operation();
		addedBehavior();
		System.out.println("����װ�ζ���B�Ĳ���");
	}
	
	private void addedBehavior() {
		System.out.println("���ⷽ��addedBehavior");
	}
}
