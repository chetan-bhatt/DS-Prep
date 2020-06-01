package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and 
 * each combination should be a unique set of numbers.
 * @author Chetan
 *
 */
public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		helper(k, n, new ArrayList<>(), result, 0, 1);
		return result;
	}

	private void helper(int k, int n, List<Integer> chosen, List<List<Integer>> result, int sumSoFar, int index) {
		if (chosen.size() == k && sumSoFar == n) {
			result.add(new ArrayList<>(chosen));
			return;
		}
		if (chosen.size() > k || sumSoFar > n) {
			return;
		}

		for (int i = index; i <= 9; i++) {
			chosen.add(i);
			helper(k, n, chosen, result, sumSoFar + i, i + 1);
			chosen.remove(chosen.size() - 1);
		}
	}

}
