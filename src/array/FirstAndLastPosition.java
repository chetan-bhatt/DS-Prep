package array;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * @author Chetan
 *
 */
public class FirstAndLastPosition {

	public static int[] searchRange(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		int x = -1;
		int y = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				if (mid > 0 && nums[mid] > nums[mid - 1]) {
					if (x == -1) {
						x = mid;
					} else {
						y = mid;
					}
					if (x != -1 && y != -1) {
						break;
					} else {
						start = mid + 1;
					}
				}
				if (mid < nums.length - 2 && nums[mid] < nums[mid + 1]) {
					if (x == -1) {
						x = mid;
					} else {
						y = mid;
					}
					if (x != -1 && y != -1) {
						break;
					} else {
						end = mid - 1;
					}
				}
				if(start == end) {
					x = mid;
					y = mid;
					break;
				}
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		int[] result = new int[2];
		result[0] = x;
		result[1] = y;
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {8};
		int[] result = searchRange(arr, 8);
		System.out.println(Arrays.toString(result));
	}

}
