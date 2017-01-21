package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void addNode(Node node) {
        node.next = head;
		
		if ( head != null ) {
			head.prev = node;
		} else {
			tail = node;
		}

		head = node;
    }

    public void removeNode(Node node) {
        if ( node.next != null ) {
			node.next.prev = node.prev;
		}
		
		if ( node.prev != null ) {
			node.prev.next = node.next;
		}
		
		if ( node == head ) {
			head = node.next;
		}
		
		if ( node == tail ) {
			tail = node.prev;
		}
		
		node.next = node.prev = null;
    }
}
