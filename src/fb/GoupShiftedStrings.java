package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 * @author Chetan
 *
 */
public class GoupShiftedStrings {
	 public List<List<String>> groupStrings(String[] strings) {
	        List<List<String>> result = new ArrayList<>();
	        Map<String, List<String>> map = new HashMap<>();
	        
	        
	        for(String str : strings){
	            String ns = getDiffString(str);
	            List<String> list = map.get(ns);
	            if(list == null){
	                list = new ArrayList<>();
	                map.put(ns, list);
	            }
	            list.add(str);
	        }
	        for(Map.Entry<String, List<String>> entry : map.entrySet()){
	            result.add(entry.getValue());
	        }
	        return result;
	    }
	    
	    private String getDiffString(String s){
	        String newString = "";
	        int alpha = 26;
	        
	        for(int i = 1; i < s.length(); i++){
	            int diff = s.charAt(i) - s.charAt(i-1);
	            if( diff < 0){
	                newString += diff + alpha;
	            } else{
	                newString += diff;
	            }
	        }
	        return newString;
	    }
	}