package com.nwshire;

import java.util.*;

public class WordLadder2 {
    LLNode head = null;
    LLNode tail = null;

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        int steps = 0;
        int maxsize = -1;

        head = tail = null;
        wordList.add(beginWord);
        wordList.add(endWord);

        Word word = new Word(beginWord);
        while ( word != null ) {
            if ( word.lastWordEquals(endWord) ) {
                if ( maxsize < 0 ) {
                    maxsize = word.words.size();
                }

                if ( word.words.size() <= maxsize ) {
                    ladders.add(new ArrayList(word.words));
                } else {
                    break;
                }
            } else if ( maxsize < 0 || word.words.size() < maxsize ){
                char[] wArr = word.lastWord.toCharArray();
                queueWords(wordList, wArr, 0, word);
            }

            word = dequeue();
        }

        return ladders;
    }

    void queueWords(Set<String> wordList, char[] wArr, int pos, Word lWord) {
        if ( pos < wArr.length ) {
            int sPos = wArr[pos] - 'a';

            for ( int n=0; n<26; n++ ) {
                if ( n != sPos ) {
                    wArr[pos] = (char)('a' + n);
                    String newWord = String.valueOf(wArr);
                    if ( wordList.contains(newWord) && !lWord.words.contains(newWord) ) {
                        enqueue(new Word(lWord.words, newWord));
                    }
                }
            }

            wArr[pos] = (char)('a' + sPos);
            queueWords(wordList, wArr, pos+1, lWord);
        }
    }

    void enqueue(Word word) {
        LLNode node = new LLNode(word);

        if ( head == null ) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    Word dequeue() {
        LLNode node = head;

        if ( head != null ) {
            head = head.next;
            if ( node == tail ) {
                head = tail = null;
            }
        }

        return node != null ? node.word : null;
    }

    class Word {
        Set<String> words;
        String lastWord;

        Word(String word) {
            this.words = new LinkedHashSet<String>();
            this.words.add(word);
            this.lastWord = word;
        }

        Word(Set<String> words, String word) {
            this.words = new LinkedHashSet<String>(words);
            this.words.add(word);
            this.lastWord = word;
        }

        boolean lastWordEquals(String word) {
            return lastWord.equals(word);
        }
    }

    class LLNode {
        Word word;
        LLNode next;

        LLNode(Word word) {
            this.word = word;
        }
    }
}
