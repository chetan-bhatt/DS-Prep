package linkedlist.singly;

public class SwapPairs {
	public Node swapPairs(Node A) {
        if(A == null){
            return A;
        }
        Node prev = null;
        Node slow = A;
        Node fast = A;
        
        fast = fast.next;

        while(fast != null){
            slow.next = fast.next;
            fast.next = slow;
            if(prev == null){
                A = fast;
            } else{
                prev.next = fast;
            }
            prev = slow;
            slow = slow.next;
            if(slow != null)
            		fast = slow.next;
            else {
            		fast = null;
            }
        }
        return A;
    }
	
	public static void main(String[] args) {
		Node result = new SwapPairs().swapPairs(new LinkedListUtil().add(new int[] {1, 2, 3, 4, 5}));
		new LinkedListUtil().print(result);
	}
}
