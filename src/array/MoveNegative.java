package array;

import java.util.Arrays;

public class MoveNegative {
	
	private static void move(int[] arr) {
		
		int left = 0;
		int right = arr.length - 1;
		
		while(left < right) {
			if(arr[left] == 0) {
				left++;
			} else if(arr[right] == -1) {
				right --;
			} else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				
				left++;
				right--;
			}
		}
	}	
	
	public static void main(String[] args) {
		
		int[] arr = {0, -1, -1, 0, 0};
		move(arr);
		System.out.println(Arrays.toString(arr));
	}

}
