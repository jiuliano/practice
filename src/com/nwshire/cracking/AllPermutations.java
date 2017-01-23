package com.nwshire.cracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 1/22/2017.
 */
public class AllPermutations {

    List<String> allPermutations(String s) {
        List<String> result = new ArrayList<>();

        if ( s.length() == 0 ) {
            result.add("");
        } else {
            for ( int n=0; n<s.length(); n++ ) {
                char s1 = s.charAt(n);
                String substr = s.substring(0, n) + s.substring(n+1);
                List<String> subResults = allPermutations(substr);

                for ( String subResult : subResults ) {
                    result.add(s1 + subResult);
                }
            }
        }

        return(result);
    }

}
