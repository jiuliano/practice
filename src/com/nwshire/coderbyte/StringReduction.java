package com.nwshire.coderbyte;

import java.util.*;


public class StringReduction {

    public static String StringReduction(String str) {
        Deque<char[]> dq = new ArrayDeque<>();
        char[] sc = str.toCharArray();
        Set<char[]> visited = new HashSet<>();
        int result = -1;

        result = traverse(dq, sc, result);
        visited.add(sc);
        while (!dq.isEmpty()) {
            sc = dq.removeFirst();
            if (!visited.contains(sc)) {
                result = traverse(dq, sc, result);
                visited.add(sc);
            }
        }

        return String.valueOf(result);
    }

    private static int traverse(Deque<char[]> dq, char[] sc, int result) {
        boolean fc = false;
        for (int n=0; n<sc.length-1; n++) {
            if (sc[n] != sc[n+1]) {
                fc = true;
                char[] nc = getNext(sc, n);

                for (char abc : new char[] { 'a', 'b', 'c' }) {
                    if (abc != sc[n] && abc != sc[n+1]) {
                        nc[n] = abc;
                        dq.addLast(Arrays.copyOf(nc, nc.length));
                    }
                }
            }
        }

        if (!fc && result == -1 || sc.length < result) {
            result = sc.length;
        }

        return result;
    }

    private static char[] getNext(char[] sc, int n) {
        char[] nc = new char[sc.length-1];
        for (int m=0; m<n; m++) {
            nc[m] = sc[m];
        }

        for (int m=n+2; m<sc.length; m++) {
            nc[m-1] = sc[m];
        }

        return nc;
    }
}
