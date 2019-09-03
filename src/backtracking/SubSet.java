package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSet {
	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> A){
		//subsetHelper(A, new ArrayList<>());
		subsetHelperAnother(A, new ArrayList<>(), 0);
		return result;
	}
	
	private void subsetHelper(ArrayList<Integer> A, ArrayList<Integer> chosen) {
		if(A.isEmpty()) {
			result.add(new ArrayList<>(chosen));
		} else {
			int num = A.get(0);
			A.remove(0);
			
			chosen.add(num);
			subsetHelper(A, chosen);
			
			chosen.remove(chosen.size() - 1);
			subsetHelper(A, chosen);
			
			A.add(0, num);
		}
	}
	
	private void subsetHelperAnother(ArrayList<Integer> A, ArrayList<Integer> chosen, int index) {
		result.add(new ArrayList<>(chosen));
		
		for(int i=index; i < A.size(); i++) {
			chosen.add(A.get(i));
			subsetHelperAnother(A, chosen, i+1);
			chosen.remove(chosen.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3); list.add(2); list.add(1);
		
		ArrayList<ArrayList<Integer>>  result = new SubSet().subset(list);
		result.forEach(l ->{
			System.out.println(Arrays.toString(l.toArray()));
		});
	}
}
