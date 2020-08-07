package fb;

public class LCABinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return helper(root, p, q);
	}

	private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val < p.val && root.val < q.val) {
			return helper(root.right, p, q);
		}
		if (root.val > p.val && root.val > q.val) {
			return helper(root.left, p, q);
		}
		return root;
	}
}