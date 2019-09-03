package backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

	private String result;
	private int count = 0;

	public String getPermutation(int n, int k) {
		String s = "";
		count = k;
		for (int i = 1; i <= n; i++) {
			s += i;
		}
		permuteHelper(s, k, "");
		return result;
	}

	private void permuteHelper(String s, int k, String chosen) {
		if (s.isEmpty()) {
			if (count == 1) {
				result = chosen;
			}
			count--;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (result != null) {
					break;
				}
				char c = s.charAt(i);
				chosen += c;
				permuteHelper(s.substring(0, i) + s.substring(i + 1), k, chosen);
				chosen = chosen.substring(0, chosen.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		String result = new KthPermutation().getPermutation(3, 4);
		System.out.println(" result = " + result);

	}

}
