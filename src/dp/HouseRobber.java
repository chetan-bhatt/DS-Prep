package dp;

public class HouseRobber {
	public int rob(int[] nums) {

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], nums[i] + dp[i - 2]);
		}
		for (int i : dp) {
			System.out.println(i);
		}
		return dp[nums.length - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new HouseRobber().rob(new int[] {1, 2, 3, 1}));
	}
}