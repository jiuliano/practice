package com.nwshire.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer,Node> map = new HashMap<Integer,Node>();
    int capacity;
    Node lruHead = null;
    Node lruTail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        updateLru(node, false);
        return node != null ? node.value : -1;
    }

    public void set(int key, int value) {
        Node node = map.get(key);

        if ( node != null ) {
            node.value = value;
        } else {
            node = new Node(key, value);
            map.put(key, node);
        }

        updateLru(node, true);
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

            if ( trim && map.size() > capacity ) {
                Node lastLruNode = lruTail;
                removeNode(lruTail);
                if ( lastLruNode != null ) {
                    map.remove(lastLruNode.key);
                }
            }
        }
    }

    class Node {
        int key;
        int value;
        Node lruNext;
        Node lruPrev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.lruNext = null;
            this.lruPrev = null;
        }
    }
}
