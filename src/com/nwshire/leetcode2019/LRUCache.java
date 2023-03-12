package com.nwshire.leetcode2019;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Deque<Integer> dq = new ArrayDeque<>();
    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer v = m.get(key);
        refresh(key, false);

        return v != null ? v : -1;
    }

    public void put(int key, int value) {
        refresh(key, true);

        m.put(key, value);
        if (m.size() > capacity) {
            Integer ok = dq.removeLast();
            m.remove(ok);
        }
    }

    private void refresh(int key, boolean put) {
        if (m.containsKey(key)) {
            dq.remove(key);
            dq.addFirst(key);
        } else if (put) {
            dq.addFirst(key);
        }
    }
}
