package dp;

/**
 * This is not a dp problem. Just a recursive one.
 * @author Chetan
 *
 */
public class RecursiveMultiply {
	
	static int multiply(int num1, int num2) {
		int smaller = num1 < num2 ? num1 : num2;
		int bigger = num1 > num2 ? num1 :  num2;
		
		return helper(smaller, bigger);
	}
	
	private static int helper(int small, int big) {
		if(small == 0) {
			return 0;
		}
		if(small == 1) {
			return big;
		}
		int s = small >> 1;
		int half = helper(s, big);
		if(small % 2 == 0) {
			return half + half;
		} else {
			return half + half + big;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(multiply(8, 9));
		System.out.println(multiply(3, 4));
		System.out.println(multiply(7, 7));
		System.out.println(multiply(7, 0));
		System.out.println(multiply(0, 8));



		
	}

}
