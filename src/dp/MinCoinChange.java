package dp;

public class MinCoinChange {

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		return helper(coins, amount, dp);

	}

	private int helper(int[] coins, int remainder, int[] dp) {
		if (remainder < 0) {
			return -1;
		}
		if (remainder == 0) {
			return 0;
		}
		if (dp[remainder] != 0) {
			return dp[remainder];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int val = helper(coins, remainder - coins[i], dp);
			if (val >= 0 && val < min) {
				min = val + 1;
			}
			dp[remainder] = min == Integer.MAX_VALUE ? -1 : min;
		}
		return dp[remainder];
	}

	public static void main(String[] args) {
		System.out.println(new MinCoinChange().coinChange(new int[] { 1, 2, 3, 4 }, 6));

	}
}
