package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PalidromePartitioning {
	 private ArrayList<ArrayList<String>> result = new ArrayList<>();
	    public ArrayList<ArrayList<String>> partition(String a) {
	    
	    		partitionHelper(a, new ArrayList<>());
	        return result;
	    }
	    
	    private void partitionHelper(String a, ArrayList<String> chosen){
	        if(a.isEmpty()){
	           result.add(new ArrayList<>(chosen));
	            
	        } else{
	            char c = a.charAt(0);
	            
	            chosen.add(c + "");
	            partitionHelper(a.substring(1), chosen);
	            
	            chosen.remove(chosen.size() - 1);
	            partitionHelper(a.substring(1), chosen);
	          //  a = c + a;
	        }
	    }
	    
	    public static void main(String[] args) {
	    		ArrayList<ArrayList<String>> result = new PalidromePartitioning().partition("abc");
	    		result.forEach(l ->{
	    			System.out.println(Arrays.toString(l.toArray()));
	    		});
	    }
}
