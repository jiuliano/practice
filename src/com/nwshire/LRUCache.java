package com.nwshire;

import java.util.Iterator;

public class LRUCache<K,V> {
    int capacity;
    int count = 0;
    int size = 997;
    Node<K,V>[] hashMap;
    Node lruHead = null;
    Node lruTail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new Node[size];
    }

    public V get(K key) {
        int idx = key.hashCode() % size;

        Node<K,V> node = hashMap[idx];
        while ( node != null && !node.key.equals(key) ) {
            node = node.hNext;
        }

        updateLru(node, false);
        return node != null ? node.value : null;
    }

    public void put(K key, V value) {
        int idx = key.hashCode() % size;

        Node<K,V> node = hashMap[idx];
        while ( node != null && !node.key.equals(key) ) {
            node = node.hNext;
        }

        if ( node != null ) {
            node.value = value;
        } else {
            node = new Node<K,V>(key, value);
            node.hNext = hashMap[idx];
            hashMap[idx] = node;
            ++count;
        }

        updateLru(node, true);
    }

    public Iterator<K> keyIterator() {
        return new KeyIterator(lruHead);
    }

    private void remove(K key) {
        int idx = key.hashCode() % size;

        Node<K,V> lastNode = null;
        Node<K,V> node = hashMap[idx];
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

    private void removeNode(Node<K,V> node) {
        Node<K,V> pn = node.lruPrev;
        Node<K,V> nn = node.lruNext;

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

    private void pushNode(Node<K,V> node) {
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

    private void updateLru(Node<K,V> node, boolean trim) {
        if ( node != null ) {
            if ( node != lruHead ) {
                removeNode(node);
                pushNode(node);
            }

            if ( trim && count > capacity ) {
                Node<K,V> lastLruNode = lruTail;
                removeNode(lruTail);
                if ( lastLruNode != null ) {
                    remove(lastLruNode.key);
                }
            }
        }
    }

    class Node<K,V> {
        K key;
        V value;
        Node hNext;
        Node lruNext;
        Node lruPrev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.hNext = null;
            this.lruNext = null;
            this.lruPrev = null;
        }
    }

    class KeyIterator implements Iterator {
        Node<K,V> node;

        KeyIterator(Node head) {
           node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public K next() {
            K key = node.key;
            node = node.lruNext;
            return key;
        }
    }
}
