package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
	 private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int i = 1; i <= A; i++){
	            list.add(i);
	        }
	        combineHelper(list, B, new ArrayList<Integer>());
	        return result;
	    }
	    
	    private void combineHelper(ArrayList<Integer> list, int B, List<Integer> chosen){
	        if(list.isEmpty() || chosen.size() == B){
		        	if(chosen.size() == 2) {
		        		ArrayList<Integer> l = new ArrayList<>(chosen);
			            result.add(l);
		        	}
	            
	            return;
	        }
	        
	        int num = list.get(0);
	        list.remove(0);
	        chosen.add(num);
	        combineHelper(list, B, chosen);
	        
	        chosen.remove(chosen.size() -1);
	        combineHelper(list, B, chosen);
	        
	        list.add(0, num);
	    }
	    
	    public static void main(String[] args) {
	    		ArrayList<ArrayList<Integer>> resultList = new Combination().combine(4,  2);
	    		resultList.forEach(list -> {
	    			System.out.println(Arrays.toString(list.toArray()));
	    		});
	    }
}
