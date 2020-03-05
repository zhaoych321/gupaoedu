package generics;

public class Box<T extends Comparable<T>> {
	
	public T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return this.t;
	}
	
	public static void main(String[] args) {
		Box<Integer> intBox = new Box<>();
		intBox.add(new Integer(10));
		System.out.println(" Box<Integer> = " + intBox.get());
		
		Box<String> stringBox = new Box<>();
		stringBox.add(new String("盖娅互娱"));
		System.out.println(" Box<String> = " + stringBox.get());
	}
}
