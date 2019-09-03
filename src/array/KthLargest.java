package array;

import java.util.Random;

public class KthLargest {
	
	static int findKthLargest(int[] nums, int k) {
		return helper(nums, k, 0, nums.length - 1);
	}
	
	static int helper(int[] nums, int k, int start, int end) {
		if(start <= end) {
			int pivot = partition(nums, start, end);
			if(pivot == nums.length-k) {
				return nums[pivot];
			} else if(pivot < nums.length-k) {
				return helper(nums, k, pivot+1, end);
			} else {
				return helper(nums, k, start, pivot-1);
			}
		}
		return -1;
	}
	
	static int partition(int[] nums, int start, int end) {
		Random rand = new Random(0);
		int choosenPivotIndex = rand.nextInt(end - start + 1) + start;
		swap(nums, choosenPivotIndex, end);
		int pivot = nums[end];
		int pIndex = start;
		
		for(int i = start; i < end; i++) {
			if(nums[i] <= pivot) {
				swap(nums, pIndex, i);
				pIndex++;
			}
		}
		swap(nums, pIndex, end);
		System.out.println(" final pivot index = " + pIndex);
		return pIndex;
	}
	
	static void swap(int[] nums, int pos1, int pos2) {
		int temp = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 5, 6, 3, 4};
		System.out.println(findKthLargest(arr, 2));
	}

}
