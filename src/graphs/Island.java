package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Island
{
    
    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static int findIslands(List<List<Integer>> list, int N, int M)
    {
        // Your code here
        int count = 0;
        int[][] adjMatrix = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(i).size(); j++){
                adjMatrix[i][j] = list.get(i).get(j);
                visited[i][j] = false;
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
            		System.out.println("adjMatrix[i][j] = " + adjMatrix[i][j] + " visited = " + visited[i][j]);
                if(adjMatrix[i][j] == 1 && !visited[i][j]){
                    dfs(i, j, adjMatrix, visited, N, M);
                    count++;
                }
            }
        }
        return count;
    }
    
    static void dfs(int row, int col, int[][] adjMatrix, boolean[][] visited, int N, int M){
        if(row < 0 || row >= N){
            return;
        }
        if(col < 0 || col >= M){
            return;
        }
        if(adjMatrix[row][col] != 1 || visited[row][col]){
            return;
        } else if(adjMatrix[row][col] == 1 && !visited[row][col]) {
        		visited[row][col] = true;
        }
        dfs(row + 1, col, adjMatrix, visited, N, M);
        dfs(row - 1, col, adjMatrix, visited, N, M);
        dfs(row, col + 1, adjMatrix, visited, N, M);
        dfs(row, col - 1, adjMatrix, visited, N, M);
        dfs(row + 1, col + 1, adjMatrix, visited, N, M);
        dfs(row - 1, col - 1, adjMatrix, visited, N, M);
        dfs(row + 1, col - 1, adjMatrix, visited, N, M);
        dfs(row - 1, col + 1, adjMatrix, visited, N, M);
    }
    
    public static void main(String[] args) {
	    	List<List<Integer>> input = new ArrayList<>();
	    	
	    	input.add(Arrays.asList(new Integer[] {1, 1, 1, 1, 0, 0, 1}));
	    	input.add(Arrays.asList(new Integer[] {1, 0, 1, 0, 1, 1, 0}));
	    	input.add(Arrays.asList(new Integer[] {0, 0, 0, 0, 1, 0, 1}));
	    	input.add(Arrays.asList(new Integer[] {1, 0, 0, 0, 1, 1, 1}));
	    	System.out.println(findIslands(input, 4, 7));
    }
}