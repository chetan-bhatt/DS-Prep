package strings;

public class SearchPattern {
	
	public int search(String s, String pattern) {
		if(s == null || pattern == null) {
			return -1;
		}
		
		int n = s.length();
		int m = pattern.length();
		
		for(int i = 0; i <= n-m; i++) {
			int j;
			
			for(j = 0; j < m; j++) {
				if(s.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j == m) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new SearchPattern().search("abcdefgh", "xxx"));
	}

}
