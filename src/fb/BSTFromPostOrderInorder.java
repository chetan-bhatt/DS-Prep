package fb;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * inorder = [9,3,15,20,7] postorder = [9,15,7,20,3] Return the following binary
 * tree:
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * @author Chetan
 *
 */
public class BSTFromPostOrderInorder {
	private int count = 0;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		count = postorder.length - 1;

		return helper(postorder, 0, postorder.length - 1, map);
	}

	private TreeNode helper(int[] postorder, int start, int end, Map<Integer, Integer> map) {
		if (start > end) {
			return null;
		}

		TreeNode node = new TreeNode(postorder[count--]);
		if (start == end) {
			return node;
		}

		int index = map.get(node.val);
		node.right = helper(postorder, index + 1, end, map);
		node.left = helper(postorder, start, index - 1, map);
		return node;

	}
}
