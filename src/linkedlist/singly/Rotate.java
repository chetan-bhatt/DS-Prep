package linkedlist.singly;

public class Rotate {
	
	public Node rotateRight(Node A, int B) {
        Node fast = A;
        Node slow = A;
        Node curr = A;
        
        int count = 0;
        while(fast != null && count < B){
            fast = fast.next;
            count++;
        }
        
        if(fast == null){
            return curr;
        } else{
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            Node revSecondHalf = reverse(slow.next);
            slow.next = null;
            curr = reverse(curr);
            Node node = curr;
            while(node.next != null){
                node = node.next;
            }
            node.next = revSecondHalf;
            
            return reverse(curr);
        }
        //return null;
    }
    
    private Node reverse(Node node){
        Node curr = node;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
	
	public static void main(String[] args) {
		System.out.println("starting");
		LinkedListUtil util = new LinkedListUtil();
		Node node = util.add(new int[] {1, 2, 3, 4, 5});
		Node result = new Rotate().rotateRight(node, 2);
		util.print(result);
	}

		
}
