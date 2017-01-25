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
        char[] cw = word.toCharArray();
		TrieNode node = head;
		
		for ( char c : cw ) {
			if ( node.children[c] == null )
			    node.children[c] = new TrieNode();
			
			node = node.children[c];
		}
		
		node.word = word;
    }

    public TrieNode getNode(String prefixOrWord) {
        TrieNode node = head;
		char[] porw = prefixOrWord.toCharArray();
		
		for ( char c : porw ) {
			node = node.children[c];
			if ( node == null ) break;
		}

        return node;
    }
}
