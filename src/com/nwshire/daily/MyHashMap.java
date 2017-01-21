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
        int idx = getIndex(key);
		Entry e = getEntry(key, map[idx]);

		if ( e != null ) {
			e.value = value;
		} else {
			e = new Entry(key, value);
			e.next = map[idx];

			if ( map[idx] != null ) {
				map[idx].prev = e;
			}

			map[idx] = e;
		}

    }

    public V get(K key) {
		int idx = getIndex(key);
		Entry e = getEntry(key, map[idx]);

        return e != null ? (V)e.value : null;
    }

    public V remove(K key) {
		int idx = getIndex(key);
		Entry e = getEntry(key, map[idx]);

		if ( e != null ) {
		    if ( e == map[idx] ) {
				map[idx] = e.next;
			}

			if ( e.next != null ) {
				e.next.prev = e.prev;
			}

			if ( e.prev != null ) {
				e.prev.next = e.next;
			}
		}

        return e != null ? (V)e.value : null;
    }

	private Entry getEntry(K key, Entry e) {
		while ( e != null ) {
			if ( e.key.equals(key) ) {
				break;
			}

			e = e.next;
		}

		return e;
	}

	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % map.length;
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
