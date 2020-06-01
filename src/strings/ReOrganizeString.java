package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReOrganizeString {
	public String reorganizeString(String S) {
        if(S == null || S.length() == 0){
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > (S.length() + 1)/2){
                return "";
            }
            queue.add(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty() && queue.size() >= 2){
            Map.Entry<Character, Integer> entry1 = queue.poll();
            Map.Entry<Character, Integer> entry2 = queue.poll();
            
            sb.append(entry1.getKey());
            sb.append(entry2.getKey());
            
            int count1 = entry1.getValue();
            if(--count1 > 0){
                entry1.setValue(count1);
                queue.add(entry1);
            }
            
            int count2 = entry2.getValue();
            if(--count2 > 0){
                entry2.setValue(count2);
                queue.add(entry2);
            }
        }
        if(!queue.isEmpty()){
            sb.append(queue.poll().getKey());
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "abce";
		System.out.println(s.indexOf(""));
	}
}