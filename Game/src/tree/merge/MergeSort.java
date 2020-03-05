package tree.merge;

import java.util.Arrays;

public class MergeSort {
	
	public static void mergeSort(int[] data, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(data, left, mid);
			mergeSort(data, mid + 1, right);
			
			//合并
			merge(data, mid, left, right);
		}
	}
	
	public static void merge(int[] data, int mid, int left, int right) {
		
		int[] temp = new int[data.length];
		
		int pos1 = left;
		int pos2 = mid + 1;
		
		int loc = left;
		while (pos1 <= mid && pos2 <= right) {
			if (data[pos1] <= data[pos2]) {
				temp[loc ++] = data[pos1 ++];
			} else {
				temp[loc ++] = data[pos2 ++];
			}
		}
		
		while (pos1 <= mid) {
			temp[loc ++] = data[pos1 ++];
		}
		
		while (pos2 <= right) {
			temp[loc ++] = data[pos2 ++];
		}
		
		for (int i = left; i <= right; i++) {
			data[i] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		int[] data = {4,3,6,5,9,10,7,1,2};
		mergeSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}
}
