package dp;

public class MinJumpsArray {

	static int minJumps(int[] arr) {
		int[] dp = new int[arr.length];
		return jumpHelper(arr, 0, dp);
	}

	static int jumpHelper(int[] arr, int position, int[] dp) {
		if (position >= arr.length - 1) {
			return 0;
		}
		if(dp[position] != 0) {
			return dp[position];
		}
		
		int maxJumps = arr[position];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= maxJumps; i++) {
			if(arr[position + i] == 0) {
				min = 1;
			} else {
				min = Math.min(min, 1 + jumpHelper(arr, position + i, dp));	
			}
		}
		dp[position] = min;
		return min;
	}

	public static void main(String[] args) {
		//System.out.println(minJumps(new int[] { 2, 3, 1, 1, 4 }));
		int[] arr = {2,3,0,1,4};
		System.out.println(minJumps(arr));
	}
}
