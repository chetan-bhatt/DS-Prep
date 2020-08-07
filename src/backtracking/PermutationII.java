package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * @author Chetan
 *
 */
public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> list = new ArrayList<>();
		for (int i : nums) {
			list.add(i);
		}

		helper(list, new ArrayList<>(), result);
		return result;
	}

	private void helper(List<Integer> list, List<Integer> chosen, List<List<Integer>> result) {
		if (list.isEmpty()) {
			result.add(new ArrayList<>(chosen));
			return;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			if (!set.contains(list.get(i))) {
				int num = list.get(i);
				set.add(list.get(i));
				chosen.add(list.get(i));
				list.remove(i);
				helper(list, chosen, result);
				chosen.remove(chosen.size() - 1);
				list.add(i, num);

			}
		}
	}
}