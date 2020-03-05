package pattern.decorator.finery;

public class BigTrouser extends Finery {

	public BigTrouser() {
	}
	
	public BigTrouser(String name) {
		super(name);
	}

	public void show() {
		System.out.print("¿å¿ã\t");
		component.show();
	}
}
