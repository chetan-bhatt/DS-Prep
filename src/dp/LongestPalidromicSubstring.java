package dp;

public class LongestPalidromicSubstring {
	
	private static int start = 0;
	private static int end = 0;
	static int longestPalindromicSubstring(String s) {
		
		for(int i = 0; i < s.length() - 1; i++) {
			helper(s, i, i);
			helper(s, i, i+1);
		}
		return end - start + 1;
	}
	
	static void helper(String s, int i, int j) {
		while(i>= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		i++;
		j--;
		if(j - i > end - start) {
			start = i;
			end = j;
		}
		
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstring("aeaaebcdcbef"));
	}
}
