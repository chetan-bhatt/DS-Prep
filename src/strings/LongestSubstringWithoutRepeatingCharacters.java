package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0){
		    return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0, longest = 0;

		while(j < s.length()){
		    if(map.containsKey(s.charAt(j))){
			i = Math.max(i, map.get(s.charAt(j)));
		    }
		    map.put(s.charAt(j), j + 1);
		    longest = Math.max(longest, j - i + 1);
		    j++;
		}
		return longest;
    	}
	
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
	}
        
	
	
}
