package array;

public class FindMinRotatedSortedWithDup {
	public int findMin(int[] nums) {
		// 3, 1, 3
		// 3, 1, 3, 3
		// 3, 3, 1, 3

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			while (nums[low] == nums[high] && low != high) {
				low++;
			}
			if (nums[low] <= nums[high]) {
				return nums[low];
			}

			int mid = low + (high - low) / 2;
			if (nums[mid] >= nums[low]) {
				low = mid + 1;
			} else {
				high = mid;
			}

		}
		return -1;
	}
}
