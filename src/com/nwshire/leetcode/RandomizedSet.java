package com.nwshire.leetcode;

import java.util.*;

/**
 * Created by james on 1/22/2017.
 */
public class RandomizedSet {
    Map<Integer,Integer> valueToIdx = new HashMap<>();
    List<Integer> valueList = new ArrayList<>();
    Random random = new Random(System.currentTimeMillis());

    /** Initialize your data structure here. */
    public RandomizedSet() {
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean inserted = !valueToIdx.containsKey(val);
        if ( inserted ) {
            int nextIdx = valueList.size();
            valueToIdx.put(val,nextIdx);
            valueList.add(val);
        }

        return inserted;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean removed = valueToIdx.containsKey(val);

        if ( removed ) {
            int lastIdx = valueList.size() - 1;
            int replaceIdx = valueToIdx.remove(val);
            int replaceValue = valueList.remove(lastIdx);
            
            if ( replaceIdx != lastIdx ) {
                valueList.set(replaceIdx, replaceValue);
                valueToIdx.put(replaceValue, replaceIdx);
            }
        }

        return removed;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIdx = random.nextInt(valueList.size());
        return valueList.get(randomIdx);
    }
}
