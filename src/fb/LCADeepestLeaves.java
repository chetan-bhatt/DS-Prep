package fb;

public class LCADeepestLeaves {
	public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null){
            return null;
        }
        
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        
        if(leftDepth > rightDepth){
            return lcaDeepestLeaves(root.left);
        } else if (leftDepth < rightDepth){
            return lcaDeepestLeaves(root.right);
        }
        return root;
    }
    
    private int findDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int left = findDepth(node.left);
        int right = findDepth(node.right);
        return Math.max(left, right) + 1;
    }
}
