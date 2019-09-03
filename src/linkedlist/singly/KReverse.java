package linkedlist.singly;

public class KReverse {
	
	public Node reverse(Node A, int B) {
    if ( B == 1){
        return A;
    }
    Node start = A;
    Node end = A;
    Node prev = null;
    while(end != null){
        int count = 1;
        while(count < B && end != null){
            end = end.next;
            count++;
        }
        if(count == B && end != null) {
        		Node rev = reverse(start, end.next);
            if(prev == null){
                A = rev;
            } else{
                prev.next = rev;
            }
            end = start;
    			prev = end;
    			start = end.next;
    			end = end.next;
        } else {
        		break;
        }
        	
    }
    return A;
}

	private Node reverse(Node node, Node end){
	    Node curr = node;
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
		Node result = new KReverse().reverse(new LinkedListUtil().add(new int[] {1, 2, 3, 4, 5}), 2);
		new LinkedListUtil().print(result);
	}
}
