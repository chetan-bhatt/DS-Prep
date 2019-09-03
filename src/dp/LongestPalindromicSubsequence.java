package dp;

public class LongestPalindromicSubsequence {

	static int lps(String s) {
		return  lpsHelper(s, 0, s.length()-1);
	}
	
	static int lpsHelper(String s, int left, int right) {
		if(left == right) {
			return 1;
		}
		
		if(s.charAt(left) == s.charAt(right)) {
			return 2 + lpsHelper(s, left + 1, right - 1);
		}
		
		return Math.max(lpsHelper(s, left + 1, right), lpsHelper(s, left, right - 1));
	}
	
	public static void main(String[] args) {
		System.out.println(lps("abadadaca"));
	}
}
