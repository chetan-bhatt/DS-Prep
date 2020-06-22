package backtracking;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        
        
        helper(board);
    }
    
    private boolean helper(char[][] board){
        
        for(int row = 0; row <= 8; row++){
            for(int col = 0; col <= 8; col++){
                if(board[row][col] == '.'){
                    for(char j = '1'; j <= '9'; j++){
                        if(isSafe(board, row, col, j)){
                            place(board, row, col, j);
                            if(helper(board)){
                                return true;
                            }
                            remove(board, row, col);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isSafe(char[][] board, int row, int col, char num){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == num){
                return false;
            }
            if(board[row][i] == num){
                return false;
            }
            if(board[3 * (row/3) + i/3][3 * (col/3) + i % 3] == num){
                return false;
            }
        }
        return true;
    }
    
    private void place(char[][] board, int row, int col, char num){
        board[row][col] = num;
    }
    
    private void remove(char[][] board, int row, int col){
        board[row][col] = '.';
    }
        
    public static void main(String[] args) {
    	char[][] board = {
    					{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
    					{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
    					{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
    					{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
    					{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
    					{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
    					{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
    					{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
    					{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    	
    	new SudokuSolver().solveSudoku(board);
    	
    	for(int i = 0; i <  board.length; i++) {
    		for(int j = 0; j < board[i].length; j++) {
    			System.out.print(board[i][j] + " ");
    		}
    		System.out.println();
    	}
    					
    }
}