package com.nwshire;

import java.util.*;

/**
 * Created by james on 1/17/2017.
 */
public class RandomizedSet {
    Set<Integer> s = new HashSet<>();
    List<Integer> l = new LinkedList<>();
    Random r = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean rv = s.add(val);
        if ( rv ) {
           l.add(val);
        }

        return rv;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean rv = s.remove(val);
        if ( rv ) {
            Integer vo = val;
            l.remove((Object)vo);
        }

        return rv;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int value = -1;
        int i = r.nextInt(l.size());
        return l.get(i);
    }
}