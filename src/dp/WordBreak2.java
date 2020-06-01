package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 */
public class WordBreak2 {
	private Map<String, String> memoized = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, List<String>> map = new HashMap<>();
		return wordBreakUtil2(s, wordDict, map);
	}
	
	private List<String> wordBreakUtil2(String s, List<String> wordDict, Map<String, List<String>> map){
		if(map.containsKey(s)) {
			return map.get(s);
		}
		
		List<String> result = new ArrayList<>();
		if(wordDict.contains(s)) {
			result.add(s);
		}
		for(int i = 1; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			if(wordDict.contains(prefix)) {
				List<String> resultList = wordBreakUtil2(s.substring(i), wordDict, map);
				for(String r : resultList) {
					result.add(prefix + " " + r);
				}
			}
		}
		map.put(s,  result);
		return result;
	}

}
