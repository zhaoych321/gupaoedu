package mianshi;

import java.util.HashSet;
import java.util.Set;

public class DoubleDigit {

	public static class Nums {
		private final int a;
		private final int b;
		
		public Nums(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Nums) {
				Nums cast = Nums.class.cast(obj);
				if (this.a * this.b == cast.a * cast.b) {
					return true;
				}
			}
			return false;
		}

		@Override
		public String toString() {
			return "["+this.a + "," + this.b +"]";
		}

		@Override
		public int hashCode() {
			return this.a / 10 + this.a % 10 + this.b / 10 + this.b % 10;
		}
	}
	
	public static void main(String[] args) {
		Set<Nums> list = new HashSet<>();
		for (int a1 = 11; a1 <= 99; a1 ++) {
			int a2 = change(a1);
			for (int b1 = 11; b1 <= 99; b1 ++) {
				int b2 = change(b1);
				Nums num1 = new Nums(a1, b1);
				Nums num2 = new Nums(a2, b2);
				if (num1.equals(num2)) {
					list.add(num1);
				}
			}
		}
		System.out.println(list);
	}
	
	public static int change(int a) {
		return a % 10 * 10 + a / 10;
	}
}
