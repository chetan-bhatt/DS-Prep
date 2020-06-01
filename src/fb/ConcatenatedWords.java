package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcatenatedWords {
public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Set<String> set = new HashSet<>();
        for(String word : words){
            set.add(word);
        }
        Map<String, Boolean> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String word : words){
            if(find(word, set, map)){
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean find(String word, Set<String> set, Map<String, Boolean> map){
        if(map.containsKey(word)){
            return map.get(word);
        }
        for(int i = 1; i < word.length(); i++){
            String prefix = word.substring(0, i);
            if(set.contains(prefix)){
                String suffix = word.substring(i);
                if(set.contains(suffix) || find(suffix, set, map)){
                    map.put(word, true);
                    return true;
                }
                
            }
        }
        map.put(word, false);
        return false;
    }
}