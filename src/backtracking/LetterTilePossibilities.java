package backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * You have a set of tiles, where each tile has one letter tiles[i] printed on
 * it. Return the number of possible non-empty sequences of letters you can
 * make.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "AAB" Output: 8 Explanation: The possible sequences are "A", "B",
 * "AA", "AB", "BA", "AAB", "ABA", "BAA". Example 2:
 * 
 * Input: "AAABBC" Output: 188
 * 
 * @author Chetan
 *
 */
public class LetterTilePossibilities {
	public int numTilePossibilities(String tiles) {
		Set<String> set = new HashSet<>();
		if (tiles == null || tiles.length() == 0) {
			return 0;
		}
		helper(tiles, "", set);
		return set.size();
	}

	private void helper(String rem, String chosen, Set<String> result) {
		if (rem.length() == 0) {
			if (chosen.length() != 0) {
				result.add(chosen);
			}
			return;
		}
		for (int i = 0; i < rem.length(); i++) {
			char c = rem.charAt(i);
			String newString = rem.substring(0, i) + rem.substring(i + 1);
			helper(newString, chosen, result);
			helper(newString, chosen + c, result);
		}
	}
}