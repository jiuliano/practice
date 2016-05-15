package com.nwshire;

import java.util.Iterator;

public class LRUCache {
    int capacity;
    int count = 0;
    int size = 997;
    Node[] hashMap = new Node[size];
    Node lruHead = null;
    Node lruTail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Object get(Object key) {
        int idx = key.hashCode() % size;

        Node node = hashMap[idx];
        while ( node != null && !node.key.equals(key) ) {
            node = node.hNext;
        }

        updateLru(node, false);
        return node != null ? node.value : null;
    }

    public void put(Object key, Object value) {
        int idx = key.hashCode() % size;

        Node node = hashMap[idx];
        while ( node != null && !node.key.equals(key) ) {
            node = node.hNext;
        }

        if ( node != null ) {
            node.value = value;
        } else {
            node = new Node(key, value);
            node.hNext = hashMap[idx];
            hashMap[idx] = node;
            ++count;
        }

        updateLru(node, true);
    }

    public Iterator keyIterator() {
        return new KeyIterator(lruHead);
    }

    private void remove(Object key) {
        int idx = key.hashCode() % size;

        Node lastNode = null;
        Node node = hashMap[idx];
        while ( node != null && !node.key.equals(key) ) {
            lastNode = node;
            node = node.hNext;
        }

        if ( node != null ) {
            if ( lastNode == null ) {
                hashMap[idx] = hashMap[idx].hNext;
            } else {
                lastNode.hNext = node.hNext;
            }
            --count;
        }
    }

    private void removeNode(Node node) {
        Node pn = node.lruPrev;
        Node nn = node.lruNext;

        if ( pn != null ) {
            pn.lruNext = nn;
        }

        if ( nn != null ) {
            nn.lruPrev = pn;
        }

        if ( lruHead == node ) {
            lruHead = nn;
        }

        if ( lruTail == node ) {
            lruTail = pn;
        }
    }

    private void pushNode(Node node) {
        if ( lruHead != null ) {
            lruHead.lruPrev = node;
        }

        node.lruNext = lruHead;
        node.lruPrev = null;
        lruHead = node;

        if ( lruTail == null ) {
            lruTail = lruHead;
        }
    }

    private void updateLru(Node node, boolean trim) {
        if ( node != null ) {
            if ( node != lruHead ) {
                removeNode(node);
                pushNode(node);
            }

            if ( trim && count > capacity ) {
                Node lastLruNode = lruTail;
                removeNode(lruTail);
                if ( lastLruNode != null ) {
                    remove(lastLruNode.key);
                }
            }
        }
    }

    class Node {
        Object key;
        Object value;
        Node hNext;
        Node lruNext;
        Node lruPrev;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.hNext = null;
            this.lruNext = null;
            this.lruPrev = null;
        }
    }

    class KeyIterator implements Iterator {
        Node node;

        KeyIterator(Node head) {
           node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Object next() {
            Object key = node.key;
            node = node.lruNext;
            return key;
        }
    }
}
