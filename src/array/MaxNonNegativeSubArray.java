package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {
	static List<Integer> maxset(List<Integer> A) {
		Long sumSoFar = new Long(-1);
		int maxLeftIndex = 0;
		int maxRightIndex = 0;
		ArrayList<Integer> l = new ArrayList<>();
		
		for(int j = 0; j < A.size(); j++) {
			Long sumTemp = new Long(-1);
			int leftIndex = j;
			while(j < A.size() && A.get(j) >= 0) {
				sumTemp += A.get(j);
				j++;
			}
			if(sumTemp > sumSoFar) {
				sumSoFar = sumTemp;
				maxLeftIndex = leftIndex;
				maxRightIndex = j;
			} else if(sumTemp == sumSoFar) {
				sumSoFar = sumTemp;
				int l1 = (maxRightIndex-maxLeftIndex);
				int l2 = (j-leftIndex);
				if(l2 > l1) {
					maxRightIndex = j;
					maxLeftIndex = leftIndex;
				} 
			}
		}
		List<Integer> result = new ArrayList<>();
		for(int i = maxLeftIndex; i < maxRightIndex; i++) {
			result.add(A.get(i));
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(-1);
		list.add(0);

		List<Integer> result = maxset(list);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
