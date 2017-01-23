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
        Entry<K,V> entry = getEntry(key);
		
		if ( entry != null ) 
			entry.value = value;
		else {
			entry = new Entry<>(key,value);
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
		
		if (entry != null) {
			int idx = getIndex(key);
			if ( map[idx] == entry ) {
				map[idx] = map[idx].next;
			} else {
				Entry nEntry = map[idx];
				while ( nEntry.next != null ) {
					if ( nEntry.next == entry ) break;
					nEntry = nEntry.next;
				}
				
				nEntry.next = entry.next;
			}
		}

        return entry != null ? entry.value : null;
    }
	
	int getIndex(K key) {
		return Math.abs(key.hashCode()) % map.length;
	}
	
	Entry getEntry(K key) {
		int idx = getIndex(key);
		Entry entry = map[idx];
		
		while ( entry != null ) {
			if ( entry.key.equals(key) ) break;
			entry = entry.next;
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
