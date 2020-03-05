package jvm;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeakDemo {
	static class Key {
		Integer id;
		
		public Key(Integer id) {
			this.id = id;
		}
		
		@Override
		public int hashCode() {
			return id.hashCode();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Map m = new HashMap();
		while (true) {
			for (int i = 0; i < 10000; i++) {
				if (!m.containsKey(new Key(i))) {
					m.put(new Key(i), "Number:"+i);
				}
			}
			
		}
	}
}
