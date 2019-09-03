package dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Chetan
 *
 */
public class ClimbStairs {
	private int[] cache;
    public int climbStairs(int n) {
        cache = new int[n+1];
        return climbHelper(n);
    }
    
    private int climbHelper(int n){
        if(n <= 1){
            return 1;
        }
        if(cache[n] != 0){
            return cache[n];
        }
        cache[n] = climbHelper(n-1) + climbHelper(n-2);
        return cache[n];
    }
    
    public static void main(String[] args) {
    		System.out.println(new ClimbStairs().climbStairs(44));
    }
}
