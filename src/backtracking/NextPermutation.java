package backtracking;

import java.util.Arrays;

public class NextPermutation {

	/**
	 * 1. Find the largest x such that P[x]<P[x+1].
	 *    (If there is no such x, P is the last permutation.)
	 * 2. Find the largest y such that P[x]<P[y].
	 * 3. Swap P[x] and P[y].
	 * 4. Reverse P[x+1 .. n].
	 * @param arr
	 */
	static void nextPermutation(int[] arr) {
		int largestX = -1;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				largestX = i;
			}
		}
		System.out.println("largest x =  " + largestX);
		int largestY = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[largestX] < arr[i]) {
				largestY = i;
			}
		}
		System.out.println(" largest y = " + largestY);
		swap(arr, largestX, largestY);
		reverse(arr, largestX+1, arr.length-1);
		System.out.println("next permutation = " + Arrays.toString(arr));

	}

	/**
	 * 1) scan from right to left, find the first element that is less than its
	 * previous one. 2) scan from right to left, find the first element that is
	 * greater than p. 3) swap p and q 4) reverse elements [p+1, nums.length]
	 * 
	 * @param arr
	 */
	static void nextPermuationAnother(int[] arr) {
		int p = -1;
		int q = arr.length - 1;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] > arr[i - 1]) {
				p = i-1;
				break;
			}
		}
		if (p == -1) {
			reverse(arr, 0, arr.length - 1);
		} else {
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] > arr[p]) {
					q = i;
					break;
				}
			}
			swap(arr, p, q);
			reverse(arr, p + 1, arr.length - 1);
		}

		System.out.println("next permutation = " + Arrays.toString(arr));
	}

	private static void reverse(int[] arr, int i, int j) {
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	public static void main(String[] args) {
		nextPermuationAnother(new int[] { 1, 2, 3, 7, 1, 9 });
		nextPermutation(new int[] { 1, 2, 3, 7, 1, 9 });


	}

}
