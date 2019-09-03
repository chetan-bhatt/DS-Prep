package backtracking;

import java.util.ArrayList;

public class GenerateParenthesis {
	private ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> generateParenthesis(int A) {
    		
        helper("", A, A);
        return result;
    }
    
    private void helper(String s, int left, int right){
        if(left > right) {
        		return;
        }
        if(left == 0 && right == 0) {
        		result.add(s);
        		return;
        }
        if(left > 0) {
        		helper(s + "(", left - 1, right);
        }
        if(right > 0) {
        		helper(s + ")", left, right - 1);
        }
    }
    
    public static void main(String[] args) {
    		ArrayList<String> result = new GenerateParenthesis().generateParenthesis(3);
    		result.forEach( s ->{
    			System.out.println(s);
    		});
    }
}
