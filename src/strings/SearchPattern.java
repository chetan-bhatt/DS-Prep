package strings;

public class SearchPattern {
	
	public int search(String s, String pattern) {
		if(s == null || pattern == null) {
			return -1;
		}
		
		for(int i = 0; i <= s.length() - pattern.length(); i++) {
			int j;
			for(j = 0; j < pattern.length(); j++) {
				if(s.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j == pattern.length()) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(new SearchPattern().search("abcdefgh", "de"));
	}

}
