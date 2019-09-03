package linkedlist.singly;


class Node {
	
	int data;
	
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}
public class LinkedListUtil {
	
	private Node head;
	
	public Node add(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		
		return head;
	}
	
	public Node add(int[] arr) {
		for(int i = arr.length - 1; i >= 0; i--) {
			add(arr[i]);
		}
		return head;
	}
	
	
	public void print(Node head) {
		Node curr = head;
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
