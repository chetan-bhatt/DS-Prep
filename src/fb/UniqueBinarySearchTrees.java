package fb;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 
 * Input: 3
Output: 5

1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * @author Chetan
 *
 */
public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
	
		long c = 1;
        
        for(int i = 0; i < n; i++)
            c = c * 2 * (2 * i + 1)/(i + 2);
        
        return (int)c;
	}
}
