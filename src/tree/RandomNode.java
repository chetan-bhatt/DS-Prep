package tree;

import java.util.Random;


public class RandomNode {
	private class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		private int size;
		
		public TreeNode(int val) {
			this.val = val;
			this.size = 1;
		}
		
		public TreeNode getIthNode(int i) {
			int leftSize = (left == null) ? 0 : left.size;
			if(i < leftSize) {
				return left.getIthNode(i);
			} else if(i == leftSize) {
				return this;
			} else {
				return right.getIthNode(i - (leftSize + 1));
			}
		}
		
		public void insertInOrder(int val) {
			if(val <= this.val ) {
				if(left == null) {
					left = new TreeNode(val);
				} else {
					left.insertInOrder(val);
				}
			} else {
				if(right == null) {
					right = new TreeNode(val);
				} else {
					right.insertInOrder(val);
				}
			}
			size++;
		}
		
		public int getSize() {
			return size;
		}
		
		public int getValue() {
			return this.val;
		}
	}

	private TreeNode root;
	
	public int size() {
		return (root == null) ? 0 : root.getSize();
	}
	
	public TreeNode getRandom() {
		if(root == null) {
			return null;
		}
		
		int i = new Random().nextInt();
		return root.getIthNode(i);
	}
	
	public void insertInOrder(int val) {
		if(root == null) {
			root = new TreeNode(val);
		} else {
			root.insertInOrder(val);
		}
	}
}
