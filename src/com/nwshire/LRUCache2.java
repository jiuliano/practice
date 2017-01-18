package com.nwshire;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by james on 1/18/2017.
 */
public class LRUCache2 {
    private List<String> lru = new LinkedList<>();
    private Map<String,String> map = new HashMap<>();
    private int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public String get(String key) {
        String value = map.get(key);

        if ( value != null ) {
            lru.remove(key);
            lru.add(0, key);
        }

        return value;
    }

    public void put(String key, String value) {
        if ( capacity > 0 ) {
            if ( lru.size() >= capacity ) {
                String rKey = lru.remove(lru.size()-1);
                map.remove(rKey);
            }

            map.put(key, value);
            lru.add(0, key);
        }
    }
}
