package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserliazeBinaryTree {
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		List<String> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root != null) {
				list.add(root.val + "");
				queue.add(root.left);
				queue.add(root.right);
			} else {
				list.add("#");
			}
		}
		return String.join(",", list);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] values = data.split(",");
		if (values.length == 0 || values[0].length() == 0 || values[0].equals("#")) {
			return null;
		}
		int index = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.valueOf(values[index++]));
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp != null) {
				TreeNode left = null;
				if (!values[index].equals("#")) {
					left = new TreeNode(Integer.valueOf(values[index]));
				}
				temp.left = left;
				queue.add(left);
				index++;

				TreeNode right = null;
				if (!values[index].equals("#")) {
					right = new TreeNode(Integer.valueOf(values[index]));
				}
				temp.right = right;
				queue.add(right);
				index++;
			}
		}
		return root;
	}
}


