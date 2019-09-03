package dp;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {

		return helper(nums, nums.length - 1);
	}

	private int helper(int[] nums, int index) {
		if (index == 0) {
			return 1;
		}
		if (index < 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		if (nums[index] > nums[index - 1]) {
			return 1 + helper(nums, index - 1);
		} else {
			for (int i = index - 1; i >= 0; i--) {
				int r = helper(nums, i);
				max = Math.max(max, r);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[] {4,10,4,3,8}));
	}
}
