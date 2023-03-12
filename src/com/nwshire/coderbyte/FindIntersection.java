package com.nwshire.coderbyte;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {
    public static String FindIntersection(String[] strArr) {
        // code goes here
        int[] n1 = getList(strArr[0]);
        int[] n2 = getList(strArr[1]);

        List<Integer> is = getIntersection(n1, n2);
        return getString(is);
    }

    private static String getString(List<Integer> is) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for (Integer i : is) {
            if (!first)
                sb.append(", ");

            sb.append(i.toString());
            first = false;
        }

        return sb.toString();
    }

    private static int[] getList(String sl) {
        String[] sll = sl.split("[,]");
        int[] list = new int[sll.length];

        for (int n=0; n<list.length; n++) {
            list[n] = Integer.valueOf(sll[n].trim());
        }

        return list;
    }

    private static List<Integer> getIntersection(int[] l1, int[] l2) {
        List<Integer> i = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] == l2[i2]) {
                i.add(l1[i1]);
                i1 += 1;
                i2 += 1;
            } else if (l1[i1] < l2[i2]) {
                i1 += 1;
            } else {
                i2 += 1;
            }
        }

        return i;
    }
}
