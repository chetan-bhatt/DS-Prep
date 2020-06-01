package fb;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
 * 
 * @author Chetan
 *
 */
public class MeetingRoom2 {
	
	public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            int[] earliest = minHeap.poll();
            
            if(earliest[1] <= current[0]){
                earliest[1] = current[1];
            } else{
                minHeap.add(current);
            }
            minHeap.add(earliest);
        }
        return minHeap.size();
    }
}
