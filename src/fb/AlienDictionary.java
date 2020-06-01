package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically 
 * by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 * 
 * @author Chetan
 *
 */
public class AlienDictionary {
	public String alienOrder(String[] words) {
		Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        
        for(String word : words){
            for(char c : word.toCharArray()){
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c : counts.keySet()){
            if(counts.get(c) == 0){
                queue.add(c);
            }
        }
        
        while(!queue.isEmpty()){
            Character c = queue.poll();
            sb.append(c);
            
            for(Character next : adjList.get(c)){
                counts.put(next, counts.get(next) - 1);
                if(counts.get(next) == 0){
                    queue.add(next);
                }
            }
        }
        
        if(sb.length() < counts.size()){
            return "";
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String ans = new AlienDictionary().alienOrder(new String[] {"wrt", "wrf", "er", "ett", "rftt"});
		System.out.println(ans);
	}
}
