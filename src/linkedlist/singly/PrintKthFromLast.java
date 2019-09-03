package linkedlist.singly;

public class PrintKthFromLast {
	
	
	public void printKthFromLast(Node head, int k) {
		if(head == null) {
			return;
		}
		int count = 0;
		Node curr = head;
		Node prev = head;
		while(curr != null && count < k) {
			curr = curr.next;
			count++;
		}
		if(curr == null) {
			return;
		}
		while(curr != null) {
			curr = curr.next;
			prev = prev.next;
		}
		System.out.println(prev.data);
	}
	
	public static void main(String[] args) {
		LinkedListUtil util = new LinkedListUtil();
		util.add(1);
		util.add(2);
		util.add(3);
		Node head = util.add(4);
		
		util.print(head);
		
		System.out.println("Kth element from last = ");
		new PrintKthFromLast().printKthFromLast(head, 2);
		
		
	}

}
