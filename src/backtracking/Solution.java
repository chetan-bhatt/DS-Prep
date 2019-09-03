package backtracking;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	private int maxNumber = 0;

	public int solution(int N) {
		// write your code in Java SE 8
		String s = N + "";

		permuteHelper(s, "");
		return maxNumber;
	}

	private void permuteHelper(String s, String chosen){
     if(s.isEmpty()){
    	 	System.out.println("chosen is = " + chosen);
         if(Integer.parseInt(chosen) > maxNumber){
             maxNumber = Integer.parseInt(chosen);
         }
     } else {
	    	 for(int i = 0; i < s.length(); i++){
	             char c = s.charAt(i);
	             chosen += c;
	             permuteHelper(s.substring(0, i) + s.substring(i+1), chosen);
	             System.out.println("after helper chosen is " + chosen);
	             chosen = chosen.substring(0, chosen.length() -1 );
	             System.out.println("remmoved last from chosen = " + chosen);
	         }
	     }
     
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(123));
	}
}
