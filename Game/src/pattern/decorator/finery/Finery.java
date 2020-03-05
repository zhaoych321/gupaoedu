package pattern.decorator.finery;

public abstract class Finery extends Person {

	public Finery() {
	}
	
	public Finery(String name) {
		super(name);
	}

	protected Person component;
	
	public void Decorate(Person component) {
		this.component = component;
	}
	
	public void show() {
		if (component != null) {
			component.show();
		}
	}
}
