package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * 
 * @author Chetan
 *
 */
public class DecodeWays {
	

	public int numDecodings(String s) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        return helper(s, 0, map);
    }
    
    private int helper(String s, int index, Map<Integer, Integer> map){
        
        if(map.containsKey(index)){
            return map.get(index);
        }
        
        if(index >= s.length()){
            return 1;
        }
        if(index == s.length() - 1){
            if(s.charAt(index) == '0'){
                return 0;
            }
            return 1;
        }
        
        int count = 0;
        
        int oneDigit = Integer.parseInt(s.charAt(index) + "");
        if(oneDigit != 0){
            count += helper(s, index + 1, map);
        }
        
        int twoDigit = Integer.parseInt(s.charAt(index) + "" + s.charAt(index + 1));
        if(twoDigit >= 10 && twoDigit <= 26){
            count += helper(s, index + 2, map);
        }
        map.put(index, count);
        return count;
    }
    
    public static void main(String[] args) {
    }
}
