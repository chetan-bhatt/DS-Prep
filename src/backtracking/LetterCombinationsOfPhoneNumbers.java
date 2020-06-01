package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfPhoneNumbers {
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.isEmpty()) {
			return result;
		}
		String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		helper(digits, arr, result, "", 0);
		return result;
	}

	private static void helper(String digits, String[] arr, List<String> result, String chosen, int index) {
		if (index > digits.length() - 1) {
			result.add(chosen);
			return;
		}

		char c = digits.charAt(index);
		int ind = c - '0';
		String options = arr[ind];
		for (int i = 0; i < options.length(); i++) {
			char opt = options.charAt(i);
			chosen += opt;
			helper(digits, arr, result, chosen, index + 1);
			chosen = chosen.substring(0, chosen.length() - 1);
		}
	}

	public static void main(String[] args) {
		String number = "23";
		List<String> result = letterCombinations(number);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
