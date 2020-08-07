package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReOrganizeString {
	public String reorganizeString(String S) {
        if(S == null || S.isEmpty()){
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > (S.length() + 1)/2){
                return "";
            }
        }
        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        String result = "";
        while(maxHeap.size() >= 2){
            char c1 = maxHeap.poll();
            result += c1;
            char c2 = maxHeap.poll();
            result += c2;
            
            map.put(c1, map.get(c1) - 1);
            map.put(c2, map.get(c2) - 1);
            
            if(map.get(c1) > 0){
                maxHeap.add(c1);
            }
            if(map.get(c2) > 0){
                maxHeap.add(c2);
            }
        }
        
        while(!maxHeap.isEmpty()){
            result += maxHeap.poll();
        }
        return result;
    }
	
	public static void main(String[] args) {
		String s = "abce";
		System.out.println(s.indexOf(""));
	}
}