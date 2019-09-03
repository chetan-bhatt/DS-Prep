package dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

	static int lcs(String s1, String s2) {
		
		return lcsHelper(s1, s2, s1.length() - 1, s2.length() - 1);
	}
	
	static int lcsHelper(String s1, String s2, int s1Len, int s2Len) {
		if(s1Len < 0 || s2Len < 0) {
			return 0;
		}
		
		if(s1.charAt(s1Len) == s2.charAt(s2Len)) {
			return 1 + lcsHelper(s1, s2, s1Len - 1, s2Len -1);
		}
		
		return Math.max(lcsHelper(s1, s2, s1Len, s2Len - 1), lcsHelper(s1, s2, s1Len - 1, s2Len));
	}
	
	static void lcsBottomUp(String s1, String s2) {
		int[][] mat = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i = 0; i < s1.length() + 1; i++) {
			for(int j = 0; j < s2.length() + 1; j++) {
				if(i == 0 || j == 0) {
					mat[i][j] = 0;
				} else {
					if(s1.charAt(i-1) == s2.charAt(j-1)) {
						mat[i][j] = 1 + mat[i-1][j-1];
					} else {
						mat[i][j] = Math.max(mat[i][j-1], mat[i-1][j]);
					}
				}
			}
		}
		
		System.out.println(" lcs = " + mat[s1.length()][s2.length()]);
		char[] arr = new char[mat[s1.length()][s2.length()]];
		int count = arr.length - 1;
		int i = s1.length();
		int j = s2.length();
		while(mat[i][j] != 0) {
			if(mat[i][j] == mat[i-1][j] || mat[i][j] == mat[i][j-1]) {
				if(mat[i][j] == mat[i-1][j]) {
					i--;
				} else {
					j--;
				}
			} else {
				arr[count--] = s1.charAt(i-1);
				i--;
				j--;
			}
		}
		System.out.println("lcs = " + Arrays.toString(arr));
	}
	
	
	public static void main(String[] args) {
		System.out.println(lcs("abc", "adc"));
		lcsBottomUp("abc", "adcs");
	}
}
