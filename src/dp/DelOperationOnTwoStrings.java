package dp;

/**
 * 
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * @author Chetan
 *
 */
public class DelOperationOnTwoStrings {
	
	public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        
        int min = helper(word1, word2, word1.length() - 1, word2.length() - 1, dp);
        return word1.length() - min + word2.length() - min;
    }
    
    private int helper(String s1, String s2, int i, int j, int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1 + helper(s1, s2, i-1, j-1, dp);
        } else{
            dp[i][j] = Math.max(helper(s1, s2, i, j-1, dp), helper(s1, s2, i-1, j, dp));
        }
        return dp[i][j];
    }
}
