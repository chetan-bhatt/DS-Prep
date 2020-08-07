package linkedlist.singly;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode curr = head;
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;

		if (head == null) {
			return true;
		}
		if (head.next == null) {
			return true;
		}
		if (head.next.next == null) {
			return head.val == head.next.val;
		}

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		if (prev == null && fast == null) {
			return true;
		}

		ListNode rev = null;
		if (fast != null) {
			rev = reverse(prev.next.next);
		} else {
			rev = reverse(prev.next);
		}
		prev.next = null;

		while (curr != null) {
			if (curr.val != rev.val) {
				return false;
			}
			curr = curr.next;
			rev = rev.next;
		}

		return true;
	}

	private ListNode reverse(ListNode node) {
		ListNode curr = node;
		ListNode next = null;
		ListNode prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}