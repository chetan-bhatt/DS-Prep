package graphs;

public class PrimsMST {
	
	static int size;
	static void mst(int[][] adjMatrix, int size) {
		PrimsMST.size = size;
		int[] parent = new int[size];
		int[] key = new int[size];
		boolean[] mstSet = new boolean[size];
		
		// assign keys to infinite
		for(int i = 0; i < size; i++) {
			key[i] = Integer.MAX_VALUE;
		}
		
		key[0] = 0;
		parent[0] = -1;
		
		for(int i = 0; i < size - 1; i++) {
			int minIndex = minKey(key, mstSet);
			mstSet[minIndex] = true;
			for(int j = 0; j < size; j++) {
				if(adjMatrix[minIndex][j] != 0 && adjMatrix[minIndex][j] < key[j] && !mstSet[j]) {
					key[j] = adjMatrix[minIndex][j];
					parent[j] = minIndex;
				}
			}
		}
		printMst(parent, adjMatrix);
	}
	
	static int minKey(int[] key, boolean[] mstSet) {
		int minKey = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i < key.length; i++) {
			if(key[i] < minKey && !mstSet[i]) {
				minKey = i;
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	static void printMst(int[] parent, int[][] adjMatrix) {
        System.out.println("Edge \tWeight"); 
        for(int i = 1; i < size; i++) {
        		System.out.println(parent[i] + " - " +  i + "\t" + adjMatrix[i][parent[i]]);
        }
	}
	
	public static void main(String[] args) {
		 /* Let us create the following graph 
        2 3 
        (0)--(1)--(2) 
        | / \ | 
        6| 8/ \5 |7 
        | /     \ | 
        (3)-------(4) 
            9         */
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
                                      { 2, 0, 3, 8, 5 }, 
                                      { 0, 3, 0, 0, 7 }, 
                                      { 6, 8, 0, 0, 9 }, 
                                      { 0, 5, 7, 9, 0 } }; 
  
        // Print the solution 
        mst(graph, 5); 
	}
}
