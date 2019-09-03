package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationList {
	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<Integer> chosen = new ArrayList<>();
        permuteHelper(A, chosen );
        return result;
    }
    
    private void permuteHelper(ArrayList<Integer> A, ArrayList<Integer> chosen){
        if(A.isEmpty()){
        		ArrayList<Integer> list = new ArrayList<>(chosen);
            result.add(list);
            return;
        }
        for(int i = 0; i < A.size(); i++) {
        		int num = A.get(i);
        		chosen.add(num);
        		A.remove(i);
        		permuteHelper(A, chosen);
        		
        		A.add(i, num);
            chosen.remove(chosen.size()-1);
        }
        
        
    }
    
    public static void main(String[] args) {
    		ArrayList<Integer> list = new ArrayList<>();
    		list.add(1);
    		list.add(2);
    		list.add(3);
		ArrayList<ArrayList<Integer>> result = new PermutationList().permute(list);
		result.forEach(e ->{
			System.out.println(Arrays.toString(e.toArray()));
		});
    }

}
