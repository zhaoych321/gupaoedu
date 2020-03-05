package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 某公司内有 4 个项⽬组，项⽬组 A、B、C、D，项⽬组A现有10⼈，项⽬组B现有7⼈，项⽬组C现
有5⼈，项⽬组D现有4⼈。为了实现跨项⽬组协作，公司决定每⽉从⼈数最多的项⽬组中抽调 3 ⼈
出来，到其他剩下 3 组中，每组 1 ⼈，这称之为⼀次调整优化（亦即经过第⼀次调整后，A组有7
⼈，B组有8⼈，C组有6⼈，D组有5⼈）。那么请问，经过⼗年的优化调整后，各项⽬组各有⼏⼈？
编程求解该问题。
 * @author admin
 *
 */
public class BuMenYouHua {
	
	public static void calDepartment(List<Department> list) {
		
		int count = 12 * 10;
		
		while (count -- > 0) {
			Collections.sort(list);
			Department max = list.get(0);
			max.sub();
			
			for (Department department : list) {
				if (department.name.equals(max.name)) continue;
			
				department.add();
			}
			
		}
	}
	
	public static void main(String[] args) {
		List<Department> list = new ArrayList<Department>();
		list.add(new Department("A", 10));
		list.add(new Department("B", 7));
		list.add(new Department("C", 5));
		list.add(new Department("D", 4));
		
		long start = System.currentTimeMillis();
		calDepartment(list);
		System.out.println("use time = " + (System.currentTimeMillis() - start));
		System.out.println(list.toString());
	}
	
	public static class Department implements Comparable<Department>{
		private final String name;
		private int num;
		
		public Department(String name, int num) {
			this.name = name;
			this.num = num;
		}
		
		public void add() {
			this.num ++;
		}
		
		public void sub() {
			this.num -= 3;
		}
		
		public int getNum() {
			return this.num;
		}

		@Override
		public int compareTo(Department o) {
			return o.num - this.num;
		}

		@Override
		public String toString() {
			return "[" + this.name + "组，人数 ： " + this.num + "]";
		}
	}

}
