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
			int idx = getIndex(key);

			entry = new Entry(key, value);
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
		
		if ( entry != null) {
		    int idx = getIndex(key);
			
			if ( entry == map[idx] ) {
				map[idx] = map[idx].next;
			} else {
                Entry pentry = map[idx];
                
				while ( pentry != null ) {
				    if ( pentry.next == entry ) break;
				    pentry = pentry.next;
				}
				
				pentry.next = entry.next;
			}
		}

        return entry != null ? entry.value : null;
    }
	
	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % map.length;
	}
	
	private Entry getEntry(K key) {
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
