package fb;

/**
 * 
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: "abcd"
Output: "dcbabcd"
 * @author Chetan
 *
 */
public class ShortestPalindrome {
	
	public String shortestPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s).reverse();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.startsWith(sb.substring(i))) {
				return sb.substring(0, i) + s;
			}
		}
		
		return s;
	}

}
