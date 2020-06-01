package backtracking;

public class NQueens {

	private int sol = 0;

	public int totalNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '-';
			}
		}

		helper(board, 0, n);
		return sol;
	}

	private void helper(char[][] board, int col, int n) {
		if (col >= n) {
			sol++;
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		} else {
			for (int row = 0; row < n; row++) {
				if (isSafe(board, row, col)) {
					place(board, row, col);
					helper(board, col + 1, n);
					remove(board, row, col);
				}
			}
		}
	}
	
	private boolean isSafe(char[][] board, int row, int col) {
		  for (int i = 0; i < col; i++) 
	            if (board[row][i] == 'Q') 
	                return false; 
		 /* Check upper diagonal on left side */
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 'Q') 
                return false; 
  
        /* Check lower diagonal on left side */
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) 
            if (board[i][j] == 'Q') 
                return false; 
  
		return true;
	}

	private void place(char[][] board, int row, int col) {
		board[row][col] = 'Q';
	}

	private void remove(char[][] board, int row, int col) {
		board[row][col] = '-';
	}
	
	public static void main(String[] args) {
		System.out.println(new NQueens().totalNQueens(4));
	}
}
