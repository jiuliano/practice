package com.nwshire.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {
    Map<String,Set<String>> dictionaryMap = new HashMap<String,Set<String>>();

    public ValidWordAbbr(String[] dictionary) {
        for ( int n=0; n<dictionary.length; n++ ) {
            String abbr = abbreviate(dictionary[n]);
            Set<String> words = dictionaryMap.get(abbr);

            if ( words == null ) {
                words = new HashSet<String>();
                dictionaryMap.put(abbr, words);
            }

            words.add(dictionary[n]);
        }

    }

    public boolean isUnique(String word) {
        String abbr = abbreviate(word);
        Set<String> words = dictionaryMap.get(abbr);

        return words == null || words.size() == 1 && words.contains(word);
    }

    private String abbreviate(String word) {
        int len = word.length() - 2;

        if ( len > 0 ) {
            word = word.charAt(0) + String.valueOf(len) + word.charAt(len+1);
        }

        return word;
    }
}
