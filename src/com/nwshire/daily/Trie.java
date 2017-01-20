package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class Trie {
    TrieNode head;

    public Trie() {
        head = new TrieNode();
    }

    public void addWord(String word) {
        char chars[] = word.toCharArray();
		TrieNode node = head;
		
		for ( char c : chars ) {
			if ( node.children[c] == null ) {
				node.children[c] = new TrieNode();
			}
			
			node = node.children[c];
		}
		
		node.word = word;
    }

    public TrieNode getNode(String prefixOrWord) {
        char chars[] = prefixOrWord.toCharArray();
		TrieNode node = head;
		
		for ( char c : chars ) {
			if ( node.children[c] == null ) {
				node = null;
				break;
			} else {
				node = node.children[c];
			}
		}

        return node;
    }
}
