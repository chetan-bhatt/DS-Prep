package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		ArrayList<Integer> chosen = new ArrayList<>();
		Collections.sort(A);
		// ArrayList<Integer> AD = (ArrayList<Integer>)
		ArrayList <Integer> list = (ArrayList<Integer>) A.stream().distinct().collect(Collectors.toList());
		combineHelper(list , chosen, B, 0, 0);
		return result;
	}

	private void combineHelper(ArrayList<Integer> A, ArrayList<Integer> chosen, int B, int sumSoFar, int index) {

		if (sumSoFar > B) {
			return;
		}
		if (sumSoFar == B) {
			ArrayList<Integer> list = new ArrayList<>(chosen);
			result.add(list);
		} else {
			for (int i = index; i < A.size(); i++) {
				int num = A.get(i);
				chosen.add(num);
				combineHelper(A, chosen, B, sumSoFar + num, i);
				chosen.remove(chosen.size() - 1);
			}
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> list2 = new ArrayList<>();
	/*	list2.add(8);
		list2.add(10);
		list2.add(6);
		list2.add(11);
		list2.add(1);
		list2.add(16);
		list2.add(8);
*/
		list2.add(2); list2.add(3); list2.add(6); list2.add(7);
		ArrayList<ArrayList<Integer>> result = new CombinationSum().combinationSum(list2, 7);
		result.forEach(l -> {
			System.out.println(Arrays.toString(l.toArray()));
		});
	}
}
