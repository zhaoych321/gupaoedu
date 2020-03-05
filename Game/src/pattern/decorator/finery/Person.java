package pattern.decorator.finery;

public class Person {
	
	public Person() {
	}
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void show() {
		System.out.printf("×°°çµÄ%s", name);
	}
}
