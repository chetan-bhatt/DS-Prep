package linkedlist.singly;

class ListNode{
	int val;
	ListNode next;
	ListNode random;
	public ListNode(int val){
		this.val = val;
	}
}

public class CloneWithRandomPointer {
	public ListNode copyRandomList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curr = head;
        while(curr != null){
            ListNode temp = new ListNode(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        ListNode copy = head.next;
        ListNode ListNode = copy;
        while(curr != null && copy != null){
            curr.next = curr.next.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            
            curr = curr.next;
            copy = copy.next;
        }
        return ListNode;
	}
}
