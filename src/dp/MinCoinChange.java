package dp;

public class MinCoinChange {
	
	static int[] minArr;
	static int minCoinChange(int[] coins, int amount) {
		return minCoinChangeHelper(coins, amount);
	//	minArr = new int[amount + 1];
	//	return minCoinChangeTopDownHelper(coins, amount, minArr);
	}

	static int minCoinChangeHelper(int[] coins, int amount) {
		if(amount < 0) {
			return 0;
		}
		if(amount == 0) {
			return 1;
		}
		
		int min = Integer.MAX_VALUE;
		for(int c : coins) {
			min  = Math.min(min, 1 + minCoinChangeHelper(coins, amount-c));
		}
		return min;
	}
	
	static int minCoinChangeTopDownHelper(int[] coins, int remainder, int[] dp ) {
		if(remainder < 0) {
			return -1;
		}
		if(remainder == 0) {
			return 0;
		}
		if(dp[remainder] != 0) {
			return dp[remainder];
		}
		int min = Integer.MAX_VALUE;
		for(int c : coins) {
			int changeResult = minCoinChangeTopDownHelper(coins, remainder-c, dp);
			if(changeResult >= 0 && changeResult < min) {
				min = 1 + changeResult;
			}
		}
		dp[remainder] = min;
		
		return dp[remainder];
	}
	
	public static void main(String[] args) {
		System.out.println(minCoinChange(new int[]{1, 2, 3, 4}, 6));
		System.out.println(minCoinChange(new int[]{1, 2, 3, 4}, 6));

	}
}
