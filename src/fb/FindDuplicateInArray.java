package fb;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Input: [1,3,4,2,2]
	Output: 2
 * 
 * @author Chetan
 *
 */
public class FindDuplicateInArray {

	public int findDuplicate(int[] nums) {
		int fast = nums[0];
		int slow = nums[0];
		
		while(fast < nums.length) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			
			if(fast == slow) {
				break;
			}
		}
		
		fast = nums[0];
		while(fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}
	
	public static void main(String[] args) {
		int duplicate = new FindDuplicateInArray().findDuplicate(new int[] {1,3,4,2,2});
		System.out.println(duplicate);
	}
}
