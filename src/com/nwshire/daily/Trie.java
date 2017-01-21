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
        char cWord[] = word.toCharArray();
		
		TrieNode node = head;
		
		for ( char c : cWord ) {
			if ( node.children[c] == null ) {
				node.children[c] = new TrieNode();
				node = node.children[c];				
			}
		}
		
		node.word = word;
    }

    public TrieNode getNode(String prefixOrWord) {
		char cPorw[] = prefixOrWord.toCharArray();
        TrieNode node = head;
		
		if ( cPorw.length > 0 ) {
			for ( char c : cPorw ) {
				node = node.children[c];
                if ( node == null ) {
					break;
				}				
			}
		}

        return node;
    }
}
