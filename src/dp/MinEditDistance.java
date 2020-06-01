package dp;

public class MinEditDistance {
	
	static int[][] cache;
	
	static int editDistance(String s1, String s2) {
		cache = new int[s1.length() + 1][s2.length() + 1];
		for(int i = 0; i <  s1.length() + 1; i++) {
			for(int j = 0; j < s2.length() + 1; j++) {
				cache[i][j] = -1;
			}
		}
		return editDistanceHelper(s1, s2, s1.length(), s2.length());
	}
	
	static int editDistanceHelper(String s1, String s2, int s1Len, int s2Len) {
		if(s1Len == 0) {
			return s2Len;
		}
		if(s2Len == 0) {
			return s1Len;
		}
		if(s1.charAt(s1Len - 1)== s2.charAt(s2Len - 1)) {
			return editDistanceHelper(s1, s2, s1Len - 1, s2Len - 1);
		} 
		if(cache[s1Len][s2Len] != -1) {
			return cache[s1Len][s2Len];
		}
		int option1 = editDistanceHelper(s1, s2, s1Len - 1, s2Len); // delete
		int option2 = editDistanceHelper(s1, s2, s1Len-1, s2Len-1); // replace
		int option3 = editDistanceHelper(s1, s2, s1Len, s2Len-1); // insert

		cache[s1Len][s2Len] = 1 + Math.min(option1, Math.min(option2, option3));
		return cache[s1Len][s2Len];
}
	
	static int minEdit(String s1, String s2) {
		int[][] mat = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i = 0; i < s1.length() + 1; i++) {
			for(int j = 0; j < s2.length() + 1; j++) {
				if(i == 0) {
					mat[i][j] = j;
				}
				else if(j == 0) {
					mat[i][j] = i;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					mat[i][j] = mat[i-1][j-1];
				} else {
					mat[i][j] = 1 + Math.min(mat[i-1][j], Math.min(mat[i][j-1], mat[i-1][j-1]));
				}
			}
		}
		
		return mat[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(editDistance("a", "a"));
	}

}
