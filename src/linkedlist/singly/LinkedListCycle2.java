package linkedlist.singly;

public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		boolean isCycle = false;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				isCycle = true;
				break;
			}
		}
		if (!isCycle) {
			return null;
		}

		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}