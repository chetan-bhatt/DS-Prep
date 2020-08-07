package fb;

/**
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element. The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * s could be empty and contains only lowercase letters a-z. p could be empty
 * and contains only lowercase letters a-z, and characters like . or *. Example
 * 1:
 * 
 * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa". Example 2:
 * 
 * Input: s = "aa" p = "a*" Output: true Explanation: '*' means zero or more of
 * the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes
 * "aa". Example 3:
 * 
 * Input: s = "ab" p = ".*" Output: true Explanation: ".*" means "zero or more
 * (*) of any character (.)". Example 4:
 * 
 * Input: s = "aab" p = "c*a*b" Output: true Explanation: c can be repeated 0
 * times, a can be repeated 1 time. Therefore, it matches "aab". Example 5:
 * 
 * Input: s = "mississippi" p = "mis*is*p*." Output: false
 * 
 * @author Chetan
 *
 */
public class RegExMatching {
	public boolean isMatch(String s, String p) {

		return helper(s, p, 0, 0);
	}

	private boolean helper(String s, String p, int sIndex, int pIndex) {
		if (sIndex >= s.length() && pIndex >= p.length()) {
			return true;
		}

		if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
			// case for matching zero characters
			if (helper(s, p, sIndex, pIndex + 2)) {
				return true;
			}

			if (p.charAt(pIndex) == '.') {
				for (int i = sIndex; i < s.length(); i++) {
					if (helper(s, p, i + 1, pIndex + 2)) {
						return true;
					}
				}
			} else {
				for (int i = sIndex; i < s.length(); i++) {
					if (s.charAt(i) == p.charAt(pIndex)) {
						if (helper(s, p, i + 1, pIndex + 2)) {
							return true;
						}
					} else {
						return false;
					}
				}
			}
		} else if (sIndex < s.length() && pIndex < p.length()
				&& (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
			return helper(s, p, sIndex + 1, pIndex + 1);
		}
		return false;
	}
}