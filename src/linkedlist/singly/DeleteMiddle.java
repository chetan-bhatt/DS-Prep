package linkedlist.singly;

public class DeleteMiddle {
	
	public void delete(Node head) {
		if(head == null || head.next == null) {
			return;
		}
		Node fast = head;
		Node slow = head;
		Node prev = null;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = slow.next;
	}
	
	
	public void deleteNode(Node node) {
		
	}
	
	public static void main(String[] args) {
		LinkedListUtil util = new LinkedListUtil();
		Node head = util.add(new int[] {1, 2, 3, 4, 5, 6});
		util.print(head);
		
		System.out.println("after deleting middle ");
		new DeleteMiddle().delete(head);
		util.print(head);
		
		
	}
}
