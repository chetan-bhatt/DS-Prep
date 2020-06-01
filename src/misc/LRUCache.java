package misc;

import java.util.HashMap;
import java.util.Map;

class Node {
	int key;
	int value;
	Node next;
	Node prev;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class LRUCache {
	private Map<Integer, Node> map = new HashMap<>();
	private int capacity;
	private Node head;
	private Node tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			if (capacity == map.size()) {
				map.remove(tail.key);
				remove(tail);
			}
			node = insert(key, value);
			map.put(key, node);
		} else {
			node.value = value;
			remove(node);
			moveToTop(node);
		}
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node != null) {
			remove(node);
			moveToTop(node);
			return node.value;
		}
		return -1;
	}

	private void remove(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}

	private Node insert(int key, int value) {
		Node node = new Node(key, value);
		moveToTop(node);
		return node;
	}

	private void moveToTop(Node node) {
		if (head != null) {
			node.next = head;
			head.prev = node;
			head = node;
			node.prev = null;
		} else {
			head = node;
			tail = node;
		}
	}

	public static void main(String[] args) {
		LRUCache obj = new LRUCache(1);
		obj.put(2, 6);
		System.out.println(obj.get(2));
		obj.put(3, 2);
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */