package com.nwshire.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by james on 1/24/2017.
 */
public class LFUCache {
    Map<Integer,Value> map = new HashMap<>(); // map key to Value object that contains value and frequency
    TreeMap<Integer,LinkedList<Integer>> lfru = new TreeMap<>(); // map frequency to lru for that frequency
    int cap;

    public LFUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        Value vo = map.get(key);
        if ( vo != null ) {
            refresh(key, vo);
        }

        return vo != null ? vo.value : -1;
    }

    public void put(int key, int value) {
        if ( !map.containsKey(key) && map.size()+1 > cap ) {
            evict();
        }

        Value vo = map.get(key);

        if ( vo == null ) {
            vo = new Value(value);
            map.put(key, vo);
            addlfru(key, vo);
        } else {
            vo.value = value;
            refresh(key, vo);
        }
    }

    private void evict() {
        int lruKey = lfru.firstKey();
        LinkedList<Integer> lru = lfru.get(lruKey);
        int key = lru.removeLast();
        map.remove(key);

        if ( lru.size() <= 0 ) {
            lfru.remove(lruKey);
        }
    }

    private void refresh(int key, Value vo) {
        LinkedList<Integer> lru = lfru.get(vo.freq);
        lru.remove((Integer)key);

        if ( lru.size() == 0 ) {
            lfru.remove(vo.freq);
        }

        addlfru(key, vo);
    }

    private void addlfru(int key, Value vo) {
        ++vo.freq;
        LinkedList<Integer> lru = lfru.get(vo.freq);

        if ( lru == null ) {
            lru = new LinkedList<Integer>();
            lfru.put(vo.freq, lru);
        }

        lru.addFirst(key);
    }

    private class Value {
        int value;
        int freq = 0;

        Value(int value) {
            this.value = value;
        }
    }
}
