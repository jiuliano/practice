package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/20/2017.
 */
public class TrieTest {
    @Test
    public void test() throws Exception {
        String word1 = "Minneapolis";
        String word2 = "Mississippi";
        String word3 = "Minnesota";

        Trie trie = new Trie();

        trie.addWord(word1);
        trie.addWord(word2);
        trie.addWord(word3);

        TrieNode node = trie.getNode(word1);
        assertNotNull(node);
        assertEquals(node.word, word1);

        node = trie.getNode("Minn");
        assertNotNull(node);
        assertNull(node.word);

        node = trie.getNode("Msss");
        assertNull(node);
    }

}