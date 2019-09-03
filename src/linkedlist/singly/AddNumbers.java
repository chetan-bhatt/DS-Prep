package linkedlist.singly;

public class AddNumbers {
	
	public Node add(Node node1, Node node2) {
		Node result = new Node(0);
		Node curr = result;
		int carry = 0;
		while(node1 != null || node2 != null) {
			int d1 = 0, d2 = 0;
			if(node1 == null && carry == 0) {
				curr.next = node2;
				return result.next;
			} else if(node1 != null){
				d1 = node1.data;
			}
			if(node2 == null && carry == 0) {
				curr.next = node1;
				return result.next;
			} else if(node2 != null){
				d2 = node2.data;
			}
			int sum = d1 + d2 + carry;
			if(sum >= 10) {
				carry = sum/10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			if(node1 != null) {
				node1 = node1.next;
			}
			if(node2 != null) {
				node2 = node2.next;
			}
			
			Node newNode = new Node(sum);
			curr.next = newNode;
			curr = curr.next;
		}
		if(carry > 0) {
			Node newNode = new Node(carry);
			curr.next = newNode;
		}
		return result.next;	
	}
	
	public static void main(String[] args) {
		LinkedListUtil util = new LinkedListUtil();
		Node node1 = util.add(new int[] {1, 3, 3, 4});
		util = new LinkedListUtil();
		Node node2 = util.add(new int[] {9, 9});
		Node resultNode = new AddNumbers().add(node1, node2);
		util.print(resultNode);
	}
}
