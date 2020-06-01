package dp;

public class LongestPalidromicSubstring {
	
	private static int count;
	static int longestPalindromicSubstring(String s) {
		
		helper(s, 0, s.length()-1, 0);
		return count;
	}
	
	static void helper(String s1, int i, int j, int count) {
		if(i >= s1.length() - 1) {
			return ;
		}
		if(j <= 0) {
			return;
		}
		if(i == j) {
			if(s1.charAt(i) == s1.charAt(j)) {
				count++;
				return;
			} else {
				return;
			}
		}
		
		if(s1.charAt(i) == s1.charAt(j)) {
			count +=2;
			helper(s1, i+1, j-1, 0);
		} else {
			count = 0;
			helper(s1,  i+1, j, 0); helper(s1, i, j-1, 0);
		}
		
		
		
		//
		// feaaaaebcdcba
		
		
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstring("aeaaebcdcbef"));
	}
}
