package jvm;

public class ClassLoadTest {
	public static void main(String[] args) {
		System.out.println(new ClassLoadTest().getClass().getClassLoader());
		System.out.println(new ClassLoadTest().getClass().getClassLoader().getParent());
		System.out.println(new ClassLoadTest().getClass().getClassLoader().getParent().getParent());
	}
}
