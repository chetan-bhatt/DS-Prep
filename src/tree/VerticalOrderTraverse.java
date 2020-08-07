package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/** 
 * 
 * Leetcode problem 987
 * 
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 * 
 * @author Chetan
 *
 */
public class VerticalOrderTraverse {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int depth = 0;
        Map<Integer, Queue<Item>> map = new TreeMap<>();
        Map<TreeNode, Integer> distMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
   
        queue.add(root);
        distMap.put(root, 0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                root = queue.poll();
                int d = distMap.get(root);
                Queue<Item> minHeap = map.get(d);
                if(minHeap == null){
                    minHeap = new PriorityQueue<>((a, b) -> (a.depth == b.depth) ? a.val - b.val : a.depth - b.depth);
                    map.put(d, minHeap);
                }
                minHeap.add(new Item(depth, root.val));
                if(root.left != null){
                    queue.add(root.left);
                    distMap.put(root.left, d - 1);
                }
                if(root.right != null){
                    queue.add(root.right);
                    distMap.put(root.right, d + 1);
                }
            }
            depth++;
        }
        Set<Integer> set = map.keySet();
        for(Integer key : set){
            List<Integer> list = new ArrayList<>();
            Queue<Item> nq = map.get(key);
            while(!nq.isEmpty()){
                list.add(nq.poll().val);
            }
            result.add(list);
        }
        return result;
    }
}
class Item{
    int depth;
    int val;
    
    public Item(int depth, int val){
        this.depth = depth;
        this.val = val;
    }
}