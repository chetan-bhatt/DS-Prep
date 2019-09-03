package linkedlist.singly;

/**
 * Definition for singly-linked list.
 * class Node {
 *     public int val;
 *     public Node next;
 *     Node(int x) { val = x; next = null; }
 * }
 */
public class ReverseBetween {
    public Node reverseBetween(Node head, int B, int C) {
        
    		if(B == C) {
    			return head;
    		}
    		
    		Node start = head;
        Node prev = null;
        Node end = head;
        int count = 1;
        
        while(start != null && count < B){
            prev = start;
            start = start.next;
            end = end.next;
            count++;
        }
        
        for(int i = 1; i <= (C-B); i++){
            end = end.next;
        }
        if(prev != null)
        		prev.next = reverse(start, end.next);
        else {
        		head = reverse(start, end.next);
        }
        return head;
    }
    private Node reverse(Node start, Node end){
        Node curr = start;
        Node prev = end;
        Node next = null;
        while(curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
		Node n = new ReverseBetween().reverseBetween(new LinkedListUtil().add(new int[] {1, 2, 3, 4, 5}), 2, 5);
		new LinkedListUtil().print(n);
    }
}
