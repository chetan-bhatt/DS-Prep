package array;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * @author Chetan
 *
 */
public class FirstAndLastPosition {

	public int[] searchRange(int[] nums, int target) {
        int firstPos = find(nums, target);
        int lastPos = find(nums, target + 1) - 1;
        
        if(firstPos <= lastPos){
            return new int[]{firstPos, lastPos};
        } 
        return new int[]{-1, -1};
    
    }
    
    private int find(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                pos = mid;
                right = mid - 1; 
            } else{
                left = mid + 1;
            }
        }
        
        return pos;
    }
}