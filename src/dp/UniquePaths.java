package dp;

public class UniquePaths {

public int uniquePaths(int m, int n) {
        
        return helper(m-1, n-1);
    }
    
    private int helper(int row, int col){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }
        
        return helper(row-1, col) + helper(row, col-1);
    }
    
    public static void main(String[] args) {
    		int ans = new UniquePaths().uniquePaths(2, 2);
    		System.out.println(ans);
    }
}