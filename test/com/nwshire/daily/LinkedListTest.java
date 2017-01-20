package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/20/2017.
 */
public class LinkedListTest {
    @Test
    public void addNode() throws Exception {
        LinkedList linkedList = new LinkedList();

        linkedList.addNode(new Node("hello"));
        linkedList.addNode(new Node("hello"));
        linkedList.addNode(new Node("goodbye"));
        linkedList.addNode(new Node("say"));
        linkedList.addNode(new Node("I"));
        linkedList.addNode(new Node("hello"));
        linkedList.addNode(new Node("say"));
        linkedList.addNode(new Node("you"));

        Node node = linkedList.getHead();
        assertEquals(node.value, "you");
        node = node.next;
        assertEquals(node.value, "say");
        node = node.next;
        assertEquals(node.value, "hello");
        node = node.next;
        assertEquals(node.value, "I");
        node = node.next;
        assertEquals(node.value, "say");
        node = node.next;
        assertEquals(node.value, "goodbye");
        node = node.next;
        assertEquals(node.value, "hello");
        node = node.next;
        assertEquals(node.value, "hello");
        node = node.next;

        node = linkedList.getHead();
        for ( int n=0; n<2; n++ ) {
            node = node.next;
        }

        linkedList.removeNode(node);

        node = linkedList.getHead();
        linkedList.removeNode(node);

        node = linkedList.getHead();
        assertEquals(node.value, "say");
        node = node.next;
        assertEquals(node.value, "I");

        while ( node.next != null ) {
            node = node.next;
        }

        linkedList.removeNode(node);

        node = linkedList.getHead();
        int count = 0;
        while ( node != null ) {
            Node nextNode = node.next;
            linkedList.removeNode(node);
            node = nextNode;
            ++count;
        }

        assertEquals(count, 5);
        assertNull(linkedList.getHead());
    }
}