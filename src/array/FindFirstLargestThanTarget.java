package array;

/**
 * Search sorted array for first largest element than the given target k.
 * Return -1 if every element is less than or equal to k.
 * @author Chetan
 *
 */
public class FindFirstLargestThanTarget {
	
	static int find(int[] arr, int k) {
		
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if(arr[mid] == k) {
				if(arr[mid-1] > arr[mid] && arr[mid] < arr[mid + 1]) {
					return arr[mid +1];	
				} else {
					
				}
			} else {
				if(arr[mid] < arr[high]) {
					if(arr[mid] < k) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				} else {
					if(arr[mid] > k) {
						
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {8, 10, 11, 12, 3, 4, 6};
		System.out.println(find(arr, 3));
	}

}
