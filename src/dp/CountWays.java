package dp;

class CountWays{
    
    // function to count ways in which n can be
    // expressed as the sum of two or more integers
	static int ways = 0;
    static int countWays(int n){
         return countWaysHelper(n, n);
    }
    
    static int countWaysHelper(int number, int remainingNumber){
    		if(remainingNumber < 0) {
    			return -1;
    		}
    		if(remainingNumber == 0) {
    			return 0;
    		}
    		
    		int result = 0;
    		for(int i = 1; i < number; i++) {
    			int r = countWaysHelper(number, remainingNumber - i);
    			if(r >= 0) {
    				result = 1 + r;
        			System.out.println(" rsult = " + result);
    			}
    		}
    		return result;
    }
    
    public static void main(String[] args) {
    		System.out.println("total ways + " + countWays(5));
    		
    }
}
