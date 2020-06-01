package tree;


public class CheckSubTree {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * check if Tree t2 is a subTree of t1
	 * 
	 * @param t1
	 * @param t2
	 * @return
	 */
	public boolean isSubTree(TreeNode t1, TreeNode t2) {
		if(t2 == null) {
			return true;
		}
		if(t1 == null) {
			return false;
		}
		
		return  subTree(t1, t2);
	}
	
	private boolean isIdentical(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) {
			return true;
		}
		if(t1 == null||t2 == null) {
			return false;
		}
		if(t1.val != t2.val) {
			return false;
		}
	
		return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
		
	}
	
	private boolean subTree(TreeNode t1, TreeNode t2) {
		if(t1 == null) {
			return false;
		} else if(t1.val == t2.val && isIdentical(t1, t2)) {
			return true;
		}
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}
}
