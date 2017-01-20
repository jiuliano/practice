package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class MyHashMap<K,V> {
    Entry<K,V> map[];

    public MyHashMap(int size) {
        map = new Entry[size];
    }

    public void put(K key, V value) {
        int idx = getIdx(key);;
		Entry<K,V> e = map[idx];
		
		while ( e != null && !e.key.equals(key) ) {
			e = e.next;
		}
		
		if ( e == null ) {
			e = new Entry(key, value);
			e.next = map[idx];
			map[idx] = e;
		} else {
			e.value = value;
		}
    }

    public V get(K key) {
		int idx = getIdx(key);
		Entry<K,V> e = map[idx];
		
		while ( e != null && !e.key.equals(key) ) {
			e = e.next;
		}

        return e != null ? e.value : null;
    }
	
    public V remove(K key) {
		int idx = getIdx(key);
		Entry<K,V> e = map[idx];
		Entry<K,V> lastE = null;
		
		while ( e != null && !e.key.equals(key) ) {
			lastE = e;
			e = e.next;
		}

		if ( lastE != null ) {
			lastE.next = e.next;
		} else {
			map[idx] = e.next;
		}
		
        return e != null ? e.value : null;
    }

	private int getIdx(K key) {
	    return Math.abs(key.hashCode() % map.length);
	}
	
    private class Entry<K,V> {
        K key;
        V value;
        Entry next;
		
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
    }
}
