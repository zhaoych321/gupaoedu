package pattern.decorator.finery;

public class TShirts extends Finery {

	public TShirts() {
	}
	
	public TShirts(String name) {
		super(name);
	}

	public void show() {
		System.out.print("¥ÛT–Ù\t");
		component.show();
	}
}
