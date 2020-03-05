package pattern.decorator;

public class Main {
	public static void main(String[] args) {
		ConcreateComponent c = new ConcreateComponent();
		ConcreteDecoratorA a = new ConcreteDecoratorA();
		ConcreteDecoratorB b = new ConcreteDecoratorB();
		
		a.setComponent(c);
		b.setComponent(a);
		b.operation();
	}
}
