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
		
		if ( entry != null ) {
			entry.value = value;
		} else {
			entry = new Entry(key,value);
			int i = getIndex(key);
			entry.next = map[i];
			map[i] = entry;
		}
    }

    public V get(K key) {
		Entry<K,V> entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    public V remove(K key) {
        V value = null;
        Entry<K,V> entry = getEntry(key);
		
		if ( entry != null ) {
			value = entry.value;
			int i = getIndex(key);
			
			if ( map[i] == entry ) {
				map[i] = entry.next;
			} else {
				Entry pEntry = map[i];
				while ( pEntry.next != null && pEntry.next != entry ) {
					pEntry = pEntry.next;
				}
				
				if ( pEntry != null ) {
					pEntry.next = pEntry.next.next;
				}
			}
		}
		
        return value;
    }
	
	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % map.length;
	}
	
	private Entry<K,V> getEntry(K key) {
		int i = getIndex(key);
		Entry<K,V> entry = map[i];
		
		while ( entry != null ) {
			if ( entry.key.equals(key) ) break;
			entry = entry.next;
		}

		return entry;
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
