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
        Entry entry = getEntry(key);
		
		if ( entry != null ) {
			entry.value = value;
		} else {
			entry = new Entry(key, value);
			int idx = getIndex(key);
			
			entry.next = map[idx];
			map[idx] = entry;
		}
    }

    public V get(K key) {
        Entry<K,V> entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    public V remove(K key) {
        Entry<K,V> entry = getEntry(key);
		
		if ( entry != null ) {
			int idx = getIndex(key);
			
			if ( entry == map[idx] ) {
				map[idx] = map[idx].next;
			} else {
				Entry lastEntry = map[idx];
				
				while ( lastEntry != null && lastEntry.next != entry ) {
					lastEntry = lastEntry.next;
				}
				
				if ( lastEntry != null ) {
					lastEntry.next = lastEntry.next.next;
				}
			}
		}

        return entry != null ? entry.value : null;
    }
	
    private Entry<K,V> getEntry(K key) {
		int idx = getIndex(key);
		Entry entry = map[idx];
		
		while ( entry != null && !entry.key.equals(key) ) {
			entry = entry.next;
		}

		return entry;
	}	
	
	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % map.length;
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
