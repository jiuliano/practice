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
		node.prev = null;
		
		if ( head != null ) {
			head.prev = node;
		} else {
			tail = node;
		}
		
		head = node;
    }

    public void removeNode(Node node) {
        if ( node == head ) {
			head = node.next;
		}
		
		if ( node == tail ) {
		    tail = node.prev;
		}
	
	    if ( node.next != null ) {
			node.next.prev = node.prev;
		}
		
		if ( node.prev != null ) {
			node.prev.next = node.next;
		}
		
		node.next = null;
		node.prev = null;
	}
}
