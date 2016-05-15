package com.nwshire;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        LRUCacheMap lruCache = new LRUCacheMap(5);

        lruCache.put("one", "value one");
        lruCache.put("two", "value two");
        lruCache.put("three", "value three");
        lruCache.put("four", "value four");
        lruCache.put("five", "value five");

        lruCache.get("one");
        lruCache.get("two");
        lruCache.put("six", "value six");

        for (Iterator i = lruCache.keyIterator(); i.hasNext(); ) {
            String key = (String)i.next();
            String value = (String)lruCache.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
