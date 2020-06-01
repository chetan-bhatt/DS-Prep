package strings;

public class LongestPalindromicSubstring {
	private int start = 0;
	private int end = 0;

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		for(int i = 0; i < s.length(); i++) {
			expand(s, i, i);
			expand(s, i, i+1);
		}
		
		return s.substring(start, end + 1);
	}

	private void expand(String s, int i, int j) {
		while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		i++;
		j--;
		
		if(j - i + 1 > end - start + 1) {
			start = i;
			end = j;
		}
		
	}
}
