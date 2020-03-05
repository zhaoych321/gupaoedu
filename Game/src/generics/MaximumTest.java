package generics;

public class MaximumTest {
	public static <T extends Comparable<T>> T max(T a, T b, T c) {
		T max = a;
		if (b.compareTo(max) > 0) {
			max = b;
		}
		
		if (c.compareTo(max) > 0) {
			max = c;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(max(4, 10, 1)); //int
		
		System.out.println(max(8.1d, 6.8d, 1.2d)); //double
		
		System.out.println(max("hello", "please", "world")); //string
	}
}
