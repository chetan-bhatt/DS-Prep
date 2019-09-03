package array;

public class FindMinRotatedSorted {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			if (nums[low] <= nums[high]) {
				return nums[low];
			}

			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}

			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
