package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class WordLadder {
    
    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        LinkedList<Item> queue = new LinkedList<>();
        queue.add(new Item(start, 1));
        
        while(!queue.isEmpty()){
            Item curr = queue.remove();
            System.out.println("***** curr item = " + curr.word + " " + curr.count);
            System.out.println(" dictionary items = " + Arrays.toString(dictV.toArray()));
            for(Iterator<String> it = dictV.iterator(); it.hasNext();){
                String wordInDict = it.next();
                System.out.println("**** word InDict = " + wordInDict);
                if(isAdjacent(curr.word, wordInDict)){
                    Item item = new Item(wordInDict, curr.count + 1);
                    queue.add(item);
                    it.remove();
                    
                    if(wordInDict.equals(end)){
                        return item.count;
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean isAdjacent(String s, String e){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != e.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();

	//	list.add("hot"); list.add("dot"); list.add("dog"); list.add("lot"); list.add("log");
	list.add("poon"); list.add("plee");list.add("same");list.add("poie");list.add("plie");list.add("poin");list.add("plea");
		//System.out.println(new WordLadder().ladderLength("hit", "cog", list));
	System.out.println(new WordLadder().ladderLength("toon", "plea", list));
    }
}

class Item{
    String word;
    int count;
    
    public Item(String word, int count){
        this.word = word;
        this.count = count;
    }
}
