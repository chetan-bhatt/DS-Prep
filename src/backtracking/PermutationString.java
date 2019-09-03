package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationString {
	
	static List<String> permuteString(String s) {
		List<String> result = new ArrayList<>();
		permuteHelper(s, result, "");
		return result;
	}
	
	static void permuteHelper(String s, List<String> result, String chosen) {
		if(s.isEmpty()) {
			result.add(chosen);
		} else {
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				chosen += c;
				permuteHelper(s.substring(0, i) + s.substring(i+1), result, chosen);
				chosen = chosen.substring(0, chosen.length()-1);
			}	
		}
	}
	
	public static void main(String[] args) {
		List<String> result = permuteString("abc");
		System.out.println(Arrays.toString(result.toArray()));
	}

}
