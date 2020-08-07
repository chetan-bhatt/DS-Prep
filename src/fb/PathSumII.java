package fb;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1 Return:
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 * 
 * @author Chetan
 *
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();

		helper(root, sum, new ArrayList<>(), result);
		return result;
	}

	private void helper(TreeNode node, int sum, List<Integer> chosen, List<List<Integer>> result) {

		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (node.val == sum) {
				chosen.add(node.val);
				result.add(new ArrayList<>(chosen));
			} else {
				return;
			}
		}
		chosen.add(node.val);

		helper(node.left, sum - node.val, new ArrayList<>(chosen), result);
		helper(node.right, sum - node.val, new ArrayList<>(chosen), result);
	}
}