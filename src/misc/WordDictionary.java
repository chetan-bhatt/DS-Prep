package misc;

public class WordDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.arr[index] == null){
                node.arr[index] = new TrieNode();
            }
            node = node.arr[index];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        return searchNode(word, 0, node);
        
    }
    
    private boolean searchNode(String word, int i, TrieNode node){
        if(i == word.length() && node.isEnd){
            return true;
        }
        if(i >= word.length()){
            return false;
        }
        char c = word.charAt(i);
        if(c == '.'){
            for(TrieNode n : node.arr){
                if(n != null && searchNode(word, i + 1, n)){
                    return true;
                }
            }
            
        } else{
            int index = c - 'a';
            if(node.arr[index] == null){
                return false;
            }
            node = node.arr[index];
            return searchNode(word, i + 1, node);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    		WordDictionary obj  = new WordDictionary();
    		obj.addWord("at");
    		obj.addWord("and");
    		obj.addWord("an");
    		obj.addWord("add");
    		obj.search("a");
    		obj.search(".at");
    		obj.addWord("bat");
    		obj.search(".at");
    		obj.search("an.");
    		obj.search("a.d.");
    		
    }
}

class TrieNode{
    TrieNode[] arr = new TrieNode[26];
    boolean isEnd = false;
    
    public TrieNode(){
        
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */