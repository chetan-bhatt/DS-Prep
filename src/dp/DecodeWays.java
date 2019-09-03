package dp;

public class DecodeWays {
	public int numDecodings(String s) {

		return helper(s, s.length() - 1);
	}

	private int helper(String s, int index) {
		if (index == 0) {
			if (Integer.valueOf(s.charAt(index) + "") > 0)
				return 1;
			return 0;
		}
		if (index < 0) {
			return 0;
		}

		Integer digit = Integer.valueOf(s.charAt(index) + "");
		Integer digitBef = Integer.valueOf(s.charAt(index - 1) + "");

		int num = 10 * digitBef + digit;
		if (num > 10 && num < 26) {
			return 2 + helper(s, index-2);
		} else if(digit != 0){
			return 1 + helper(s, index-1);
		} else {
			return helper(s, index-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("10"));
	}

}
