package dp;

public class HouseRobberWithCycle {
	public int rob(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			if (nums.length % 2 != 0) {
				if (i != nums.length - 1)
					dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
				else {
					dp[i] = Math.max(0 + dp[i - 2], dp[i - 1]);
				}
			} else {
				dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
			}
		}
		return dp[nums.length - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new HouseRobberWithCycle().rob(new int[] {2, 1, 1, 2}));
	}
}
