package fb;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 1 / \ 2 5 / \ \ 3 4 6 The flattened tree should look like:
 * 
 * 1 \ 2 \ 3 \ 4 \ 5 \ 6
 * 
 * @author Chetan
 *
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode node = root;

		while (node != null) {
			if (node.left != null) {
				TreeNode rightNode = node.right;
				node.right = node.left;
				node.left = null;

				TreeNode rightMost = node;
				while (rightMost.right != null) {
					rightMost = rightMost.right;
				}
				rightMost.right = rightNode;
			}
			node = node.right;
		}
	}
}