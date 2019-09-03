package array;

import java.util.ArrayList;
import java.util.Map;

/*
 * Given an array of integers, sort the array into a wave like array and return it, 
 *In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 * 
 */
public class SortWave extends Exception{
	
	
	public ArrayList<Integer> wave(ArrayList<Integer> A) {
		for (int i = 0; i < A.size(); i += 2) {
			if (i > 1 && A.get(i) < A.get(i - 1)) {
				int temp = A.get(i);
				A.set(i, A.get(i - 1));
				A.set(i - 1, temp);
			}

			if (i < A.size() - 1 && A.get(i) < A.get(i + 1)) {
				int temp = A.get(i);
				A.set(i, A.get(i + 1));
				A.set(i + 1, temp);

			}
		}
		return A;
	}
}
