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
        Entry e = getEntry(key);

        if ( e != null ) {
			e.value = value;
		} else {
			e = new Entry(key,value);
		    int idx = getIndex(key);
			e.next = map[idx];
			map[idx] = e;
		}
    }

    public V get(K key) {
        Entry<K,V> e = getEntry(key);
        return e != null ? e.value : null;
    }

    public V remove(K key) {
        int idx = getIndex(key);
		Entry<K,V> e = map[idx];
		
		if ( map[idx] != null && map[idx].key.equals(key) ) {
			map[idx] = map[idx].next;
		} else {
			while ( e.next != null ) {
				if ( e.next.key.equals(key) ) break;
			}
			
			if ( e.next != null ) {
				e.next = e.next.next;
			}
		}
		
        return e != null ? e.value : null;
    }
	
	int getIndex(K key) {
		return Math.abs(key.hashCode()) % map.length;
	}
	
	Entry getEntry(K key) {
		int idx = getIndex(key);
		Entry<K,V> entry = map[idx];
		
		while ( entry != null ) {
			if ( entry.key.equals(key) ) {
				break;
			} else {
				entry = entry.next;
			}
		}
		
		return entry;
	}

    private class Entry<K,V> {
        K key;
        V value;
        Entry prev;
        Entry next;
		
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
    }
}
