package generics;


public class GenericsMethod {
	
	public static <E> void printOut(E[] array) {
		for (E e : array) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {1,3,2};
		printOut(intArray);
		Double[] doubleArray = {3.2d, 2.1d, 5.4d};
		printOut(doubleArray);
		Character[] charArray = {'b', 'd', 'a'};
		printOut(charArray);
	}
}
