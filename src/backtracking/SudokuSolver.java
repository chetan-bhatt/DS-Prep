package backtracking;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        
        helper(board);
    }
    
    private boolean helper(char[][] board){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
            		if(board[row][col] != '.') {
            			continue;
            		}
            		for(int num = 1; num <= 9; num++) {
            			char c = (char)(num+'0');
                    if(isSafe(board, row, col, c)){
                        place(board, row, col, c);
                        boolean result = helper(board);
                        if(result){
                            return true;
                        }
                        remove(board, row, col);
                    }	
            		}
            		return false;
            }
        }
    
        return true;
    }
        
        
    private boolean isSafe(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c){
                return false;
            }
        }
        for(int i = 0; i < 9; i++){
            if(board[i][col] == c){
                return false;
            }
        }
         int r = row - row%3;
        int cl = col - col%3;
        for(int i = r ; i< r+3 ; i++)
        {
            for(int j = cl; j < cl+3 ; j++)
            {
                if(board[i][j]==c)
                {
                    return false;
                }
            }

        }
        return true;
    }
        
    private void place(char[][] board, int row, int col, char c){
        board[row][col] = c;
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