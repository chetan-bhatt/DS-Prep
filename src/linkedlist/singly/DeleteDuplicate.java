package linkedlist.singly;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicate {
	
	public DeleteDuplicate() {
	}
	
	public void deleteDuplicate(Node head) {
		if(head == null || head.next == null) {
			return;
		}
        HashSet<Integer> hs = new HashSet<>(); 
      
        Node current = head; 
        Node prev = null; 
        while (current != null)  
        { 
            int curval = current.data; 
              
            if (hs.contains(curval)) { 
                prev.next = current.next; 
            } else { 
                hs.add(curval); 
                prev = current; 
            } 
            current = current.next; 
        } 	
    }
	
	public static void main(String[] args) {
		DeleteDuplicate obj = new DeleteDuplicate();
		LinkedListUtil util = new LinkedListUtil();
		util.add(4);
		util.add(4);
		util.add(1);
		util.add(2);
		util.add(2);
		Node head = util.add(1);
		
		obj.deleteDuplicate(head);
		util.print(head);
	}
}


