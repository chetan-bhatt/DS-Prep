package fb;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
	
    public List<TreeNode> generateTrees(int n) {
    		if(n == 0) {
    			return new ArrayList<>();
    		}
    		return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end){
    		List<TreeNode> result = new ArrayList<>();
    		if(start > end) {
    			result.add(null);
    			return result;
    		}
    		
    		for(int i = start; i <= end; i++) {
    			List<TreeNode> leftTrees = helper(start, i - 1);
    			List<TreeNode> rightTrees = helper(i + 1, end);
    			
    			for(TreeNode left : leftTrees) {
    				for(TreeNode right : rightTrees) {
    					TreeNode current = new TreeNode(i);
    					current.left = left;
    					current.right = right;
    					result.add(current);
    				}
    			}
    		}
    		return result;
    }

}
