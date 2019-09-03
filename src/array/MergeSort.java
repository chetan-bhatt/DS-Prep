package array;

import java.util.Arrays;

public class MergeSort {
	
	static void mergeSort(int[] arr) {
		if(arr.length <= 1) {
			return;
		}
		int[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
		int[] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);
		
		mergeSort(left);
		mergeSort(right);
		
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
				arr[i] = left[i1];
				i1++;
			} else {
				arr[i] = right[i2];
				i2++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 2, 5, 4, 1, 8, 6};
		mergeSort(arr);
 		System.out.println(Arrays.toString(arr));
	}
}
