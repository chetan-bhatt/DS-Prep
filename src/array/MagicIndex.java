package array;

public class MagicIndex {
	
	public static int findMagicIndex(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		while(low <= high) {
			int mid = (high - low)/2 + low;
			if(arr[mid] == mid) {
				return mid;
			}
			
			if(arr[mid] > mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static int findDP(int[] arr) {
		return helper(arr, 0, arr.length-1);
	}
	
	private static int helper(int[] arr, int low, int high) {
		if(high < low) {
			return -1;
		}
		int mid = ( high + low )/2;
		if(arr[mid] == mid) {
			return mid;
		}
		int leftIndex = Math.min(mid - 1, arr[mid]);
		int left = helper(arr, low, leftIndex);
		if(left >= 0) {
			return left;
		}
		int rightIndex = Math.max(mid + 1, arr[mid]);
		int right = helper(arr, rightIndex, high);
			return right;
	}
	
	
	public static void main(String[] args) {
		System.out.println(findDP(new int[] {-1, 0, 1, 3, 9, 10, 11, 12, 16}));
	}

}
