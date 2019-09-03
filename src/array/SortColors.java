package array;

import java.util.Arrays;

public class SortColors {
	public static void sortColors(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int i = 0;
		while (i < nums.length) {
			if (end >= 0 && nums[end] == 2) {
				end--;
			}
			if (start < i && nums[start] == 0) {
				start++;
			}
			if (nums[i] == 0 && i != start) {
				swap(nums, i, start);
				start++;
			} else if (nums[i] == 2 && i < end) {
				swap(nums, i, end);
				end--;
			} else {
				i++;
			}

		}
	}

	public static void sortColorsAnotherVersion(int[] nums) {

		int low = 0;
		int mid = 0;
		int high = nums.length - 1;
		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				swap(nums, mid, low);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(nums, mid, high);
				high--;
				break;
			}
		}
	}

	private static void swap(int[] nums, int pos1, int pos2) {
		int temp = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = temp;
	}

	public static void main(String[] args) {
		// int[] arr = {2,0,2,1,1,0};
		int[] arr = { 0, 0, 1, 0, 2, 1 };
		// int[] arr = {1,1,0,0,2,0,1};
		// int[] arr = {1, 2, 0};
		sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}
}
