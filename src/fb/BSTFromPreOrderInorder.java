package fb;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * preorder = [3,9,20,15,7] inorder = [9,3,15,20,7] Return the following binary
 * tree:
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * @author Chetan
 *
 */
public class BSTFromPreOrderInorder {
	private int count = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(preorder, 0, preorder.length - 1, map);
	}

	private TreeNode helper(int[] preorder, int start, int end, Map<Integer, Integer> map) {
		if (start > end) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[count++]);
		if (start == end) {
			return node;
		}

		int index = map.get(node.val);
		node.left = helper(preorder, start, index - 1, map);
		node.right = helper(preorder, index + 1, end, map);
		return node;
	}
}