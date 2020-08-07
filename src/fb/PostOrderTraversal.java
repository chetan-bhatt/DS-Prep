package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
	
	public List<Integer> postOrder(TreeNode root){
		List<Integer> result = new ArrayList<>();
		
		if(root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		if(!stack.isEmpty()) {
			root = stack.pop();
			result.add(0, root.val);
			if(root.left != null) {
				stack.push(root.left);
			}
			if(root.right != null) {
				stack.push(root.right);
			}
		}
		return result;
	}

}
