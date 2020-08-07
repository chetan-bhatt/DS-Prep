package fb;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:


https://assets.leetcode.com/uploads/2018/10/12/island.png
 * @author Chetan
 *
 */
public class IslandPerimeter {
	private int perimeter = 0;
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, visited);
                }
            }
        }
        
        return perimeter;
    }
    
    private void dfs(int[][] grid, int row, int col, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1 || visited[row][col]){
            return;
        }
        
        perimeter += 4;
        if(row - 1 >= 0 && visited[row-1][col]){
            perimeter -= 2;
        }
        if(row + 1 < grid.length && visited[row + 1][col]){
            perimeter -= 2;
        }
        if(col - 1 >= 0 && visited[row][col - 1]){
            perimeter -= 2;
        }
        if(col + 1 < grid[row].length && visited[row][col + 1]){
            perimeter -= 2;
        }
        
        grid[row][col] = 0;
        visited[row][col] = true;
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
    }
}
