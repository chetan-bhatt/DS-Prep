package linkedlist.singly;

public class ReOrderList {

	public Node reorderList(Node A) {
		Node curr = A;
		Node fast = A;
		Node slow = A;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		Node rev = reverse(slow.next);
		slow.next = null;
		while(rev != null && curr != null){
			Node node = curr.next;
			curr.next = rev;
			Node node2 = rev.next;
			rev.next = node;

			curr = node;
			rev = node2;
		}
		return A;
	}

	private Node reverse(Node node){
		Node curr = node;
		Node prev = null; Node next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
		
	}

	public static void main(String[] args) {
		Node util = new ReOrderList().reorderList(
				new LinkedListUtil().add(
						new int[] {1, 2, 3, 4, 5, 6}));
						//new int[] {90 , 94 , 25 , 51 , 45 , 29 , 55 , 63 , 48 , 27 , 72 , 10 , 36 , 68 , 16 , 20 , 31 , 7 , 95 , 70 , 89 , 23 , 22 , 9 , 74 , 71 , 35 , 5 , 80 , 11 , 49 , 92 , 69 , 6 , 37 , 84 , 78 , 28 , 43 , 64 , 96 , 57 , 83 , 13 , 73 , 97 , 75 , 59 , 53 , 52 , 19 , 18 , 98 , 12 , 81 , 24 , 15 , 60 , 79 , 34 , 1 , 54 , 93 , 65 , 44 , 4 , 87 , 14 , 67 , 26 , 30 , 77 , 58 , 85 , 33 , 21 , 46 , 82 , 76 , 88 , 66 , 101 , 61 , 47 , 8}));
		new LinkedListUtil().print(util);	
	}
}
