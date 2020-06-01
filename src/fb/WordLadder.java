package fb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * @author Chetan
 *
 */
public class WordLadder {
	class Solution {
		public int ladderLength(String beginWord, String endWord, List<String> wordList) {

			Set<String> set = new HashSet<>();
			for (String word : wordList) {
				set.add(word);
			}

			if (!set.contains(endWord)) {
				return 0;
			}

			Queue<String> queue = new LinkedList<>();
			queue.add(beginWord);

			int level = 1;

			while (!queue.isEmpty()) {
				int size = queue.size();

				for (int i = 0; i < size; i++) {
					String word = queue.poll();
					char[] wordChar = word.toCharArray();

					for (int j = 0; j < wordChar.length; j++) {
						char originalChar = wordChar[j];

						for (char c = 'a'; c <= 'z'; c++) {
							if (c == originalChar) {
								continue;
							}

							wordChar[j] = c;
							String newString = new String(wordChar);
							if (set.contains(newString)) {
								if (newString.equals(endWord)) {
									return level + 1;
								}
								queue.add(newString);
								set.remove(newString);
							}
						}
						wordChar[j] = originalChar;
					}
				}
				level++;
			}
			return 0;
		}
	}
}
