package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	
	public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
        		return 0;
        }
        
        int result = 1;
        int j = 0;
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
        		char c = s.charAt(i);
        		if(!set.contains(c)) {
        			set.add(c);
        			result = Math.max(result,  set.size());
        		} else {
        			while(j < i) {
        				if(s.charAt(j) == c) {
        					j++;
        					break;
        				}
        				set.remove(c);
        				j++;
        			}
        		}
        }
        
        return result;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
	}
        
	
	
}
