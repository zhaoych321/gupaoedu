package generics;

import java.util.LinkedList;
import java.util.List;

public class GenericTest {
	public static void main(String[] args) {
		List<Integer> aaa = new LinkedList<>();
		aaa.add(1);
		getData(aaa);
		
		List<String> bbb = new LinkedList<>();
		bbb.add("ssss");
		getData(bbb);
	}
	
	public static void getData(List<?> a) {
		System.out.println("data = " + a.get(0));
	}
}
