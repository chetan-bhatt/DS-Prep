package graphs;

public class IslandPerimeter {
	private int perimeter = 0;

	public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					dfs(i, j, grid, visited);
				}
			}
		}
		return perimeter;
	}

	private void dfs(int row, int col, int[][] grid, boolean[][] visited) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1) {
			return;
		}
        perimeter += 4;
        if((row - 1) >= 0 && visited[row-1][col]){
            perimeter -= 2; 
            System.out.println(row-1 + ", " + col + ": perimeter : "+ perimeter);
        }
        if((row + 1) < grid.length && visited[row+1][col]){
            perimeter -= 2; 
            System.out.println(row+1 + ", " + col + ": perimeter : "+ perimeter);
        }
        if((col - 1) >= 0 && visited[row][col-1]){
            perimeter -= 2; 
            System.out.println(row + ", " + (col-1) + ": perimeter : "+ perimeter);
        }
        if((col + 1) < grid[row].length && visited[row][col+1]){
            perimeter -= 2; 
            System.out.println(row + ", " + (col+1) + ": perimeter : "+ perimeter);
        }
        
		grid[row][col] = 0;
        visited[row][col] = true;

		dfs(row - 1, col, grid, visited);
		dfs(row + 1, col, grid, visited);
		dfs(row, col - 1, grid, visited);
		dfs(row, col + 1, grid, visited);
	}

	public static void main(String[] args) {
		int[][] grid = {{0, 1},
						{1, 1}};
		System.out.println(new IslandPerimeter().islandPerimeter(grid));
	}
}
