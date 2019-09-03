package array;

import java.util.Arrays;

public class QuickSort {
	
	static void quickSort(int[] arr) {
		quicksortHelper(arr, 0, arr.length-1);
	}
	
	static void quicksortHelper(int[] arr, int start, int end) {
		if(start < end) {
			int pivot = partition(arr, start, end);
			quicksortHelper(arr, start, pivot-1);
			quicksortHelper(arr, pivot+1, end);
		}
	}
	static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		
		for(int i = start; i < end; i++) {
			if(arr[i] <= pivot) {
				swap(arr, pIndex, i);
				pIndex++;
			}
		}
		swap(arr, pIndex, end);
		return pIndex;
	}
	
	static void swap(int[] arr, int position1, int position2) {
		int temp = arr[position1];
		arr[position1] = arr[position2];
		arr[position2] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 5, 3, 8, 9, 7};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
