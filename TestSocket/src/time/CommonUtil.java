package time;


import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CommonUtil {
	public static boolean isEmpty(String s) {
		return null == s || s.isEmpty();
	}
	
	public static boolean isNotEmpty(String s) {
		return null != s && !s.isEmpty();
	}
	
	public static boolean isEmpty(Collection<?> c) {
		return null == c || c.isEmpty();
	}
	
	public static boolean isNotEmpty(Collection<?> c) {
		return null != c && !c.isEmpty();
	}
	
	public static boolean isEmpty(Map<?, ?> c) {
		return null == c || c.isEmpty();
	}
	
	public static boolean isNotEmpty(Map<?, ?> c) {
		return null != c && !c.isEmpty();
	}
	
	/**
	 * 在一个�?增的list里找出第�?��大于key值的元素下标
	 * 采用二分搜索算法
	 * @param list
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int getFirstGtKeyIndex(List<T> list, T key) {
		if(isEmpty(list)) {
			return 0;
		}
		int low = 0;
		int high = list.size() - 1;
		int mid = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			T cur = list.get(mid);
			if(key.compareTo(cur) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	/**
	 * 在一个�?减的list里找出第�?��小于key值的元素下标
	 * 采用二分搜索算法
	 * @param list
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int getFirstLtKeyIndex(List<T> list, T key) {
		if(isEmpty(list)) {
			return 0;
		}
		int low = 0;
		int high = list.size() - 1;
		int mid = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			T cur = list.get(mid);
			if(key.compareTo(cur) > 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
}
