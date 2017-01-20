package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class Node {
    Object value;
    Node next;
    Node prev;

    public Node(Object value) {
        this.value = value;
        next = prev = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
