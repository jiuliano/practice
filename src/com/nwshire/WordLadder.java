package com.nwshire;

import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
    TrieNode trie = new TrieNode();

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<Word> queue = new LinkedList<Word>();
        int steps = 0;

        for ( String word : wordList ) {
            addWord(word, beginWord);
        }
        addWord(beginWord, beginWord);
        addWord(endWord, beginWord);

        queue.add(new Word(beginWord, 1));
        while ( queue.size() > 0 ) {
            Word word = queue.remove();
            //System.out.println("Dequeuing: " + word.word + ", step: " + word.step);
            if ( word.word.equals(endWord) ) {
                steps = word.step;
                break;
            }

            char[] wArr = word.word.toCharArray();
            queueWords(trie, wArr, 0, queue, word.step+1);
        }

        return steps;
    }

    void queueWords(TrieNode node, char[] wArr, int pos, LinkedList<Word> queue, int step) {
        if ( pos < wArr.length ) {
            int sPos = wArr[pos] - 'a';

            for ( int n=0; n<26; n++ ) {
                if ( n != sPos && node.nodes[n] != null ) {
                    wArr[pos] = (char)('a' + n);
                    if ( isAvailable(wArr) ) {
                        String newWord = String.valueOf(wArr);
                        //System.out.println("Queuing: " + newWord + ", step: " + step);
                        queue.add(new Word(newWord, step));
                    }
                }
            }

            wArr[pos] = (char)('a' + sPos);
            node = node.nodes[sPos];
            queueWords(node, wArr, pos+1, queue, step);
        }
    }

    boolean isAvailable(char[] wArr) {
        TrieNode node = trie;
        int n = 0;
        boolean available = false;

        while ( n<wArr.length ) {
            int sPos = wArr[n] - 'a';
            if ( node.nodes[sPos] != null ) {
                node = node.nodes[sPos];
            } else {
                break;
            }

            ++n;
        }

        if ( n == wArr.length ) {
            available = !node.visited;
            node.visited = true;
        }

        return available;
    }

    void addWord(String word, String beginWord) {
        char[] wArr = word.toCharArray();
        TrieNode node = trie;

        for ( int n=0; n<wArr.length; n++ ) {
            int i = wArr[n] - 'a';
            if ( node.nodes[i] == null ) {
                node.nodes[i] = new TrieNode();
            }

            node = node.nodes[i];
        }

        node.word = word;
        node.visited = word.equals(beginWord);
    }

    class Word {
        String word;
        int step;

        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    class TrieNode {
        TrieNode[] nodes;
        String word;
        boolean visited;

        TrieNode() {
            nodes = new TrieNode[26];
            word = null;
            visited = false;
        }
    }
}
