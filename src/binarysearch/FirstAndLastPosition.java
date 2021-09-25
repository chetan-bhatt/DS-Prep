package binarysearch;

/**
 *Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]

 Input: nums = [], target = 0
 Output: [-1,-1]
 *
 *
 */
public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {

        int first = first(nums, target);
        int last = last(nums, target);
        return new int[]{first, last};
    }

    private int first(int[] nums, int target){
        int first = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                first = mid;
                right = mid - 1;
            }

            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return first;
    }

    private int last(int[] nums, int target){
        int first = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                first = mid;
                left = mid + 1;
            }
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return first;
    }
}
