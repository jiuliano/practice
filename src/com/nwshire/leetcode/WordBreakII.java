package com.nwshire.leetcode;

import java.util.*;

/**
 * Created by james on 1/11/2017.
 */
public class WordBreakII {
    private static Map<String,List<String>> resMap = new HashMap<String,List<String>>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = resMap.get(s);

        if ( res == null ) {
            res = new ArrayList<String>();

            if ( s.length() == 0 ) {
                res.add("");
            } else {
                for ( String word : wordDict ) {
                    if ( s.startsWith(word) ) {
                        List<String> ress = wordBreak(s.substring(word.length()), wordDict);
                        for ( String rl : ress ) {
                            if ( rl.length() == 0 ) {
                                res.add(word);
                            } else {
                                res.add(word + " " + rl);
                            }
                        }
                    }
                }
            }

            resMap.put(s, res);
        }

        return res;
    }

    public static void main(String argv[]) {
        List<String> dict = Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" });
        WordBreakII wbii = new WordBreakII();
        List<String> res = wbii.wordBreak("catsanddog", dict);
        System.out.println(res);
    }
}
