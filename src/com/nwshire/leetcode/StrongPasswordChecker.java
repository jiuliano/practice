package com.nwshire.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 6/6/18.
 */
public class StrongPasswordChecker {
    int needType;
    List<CSeq> seqs;

    private void init() {
        needType = 0;
        seqs = new ArrayList<>();
    }

    public int strongPasswordChecker(String s) {
        int minChanges = 0;

        if ( s == null || s.length() == 0 ) {
            return 6;
        }

        char[] sa = s.toCharArray();

        CSeq seq = null;
        int needLc = 1;
        int needUc = 1;
        int needN = 1;

        for (int n=0; n<sa.length; n++) {
            if (sa[n] >= 'a' && sa[n] <= 'z') {
                needLc = 0;
            } else if (sa[n] >= 'A' && sa[n] <= 'Z') {
                needUc = 0;
            } else if (sa[n] >= '0' && sa[n] <= '9') {
                needN = 0;
            }

            if (seq == null) {
                seq = new CSeq(sa[n], n);
            } else if (seq.c == sa[n]) {
                ++seq.len;
            } else {
                if (seq.len >= 3) {
                    seqs.add(seq);
                }
                seq = new CSeq(sa[n], n);
            }
        }

        needType = needLc + needUc + needN;

        for (CSeq seq2 : seqs) {

        }

        return minChanges;
    }

    private class CSeq {
        char c;
        int start;
        int len;

        CSeq(char c, int start) {
            this.c = c;
            this.start = start;
            this.len = 0;
        }

        int addVal() {
            return (this.len - 1) / 2;
        }

        int delVal() {
            return (this.len - 2);
        }

        int repVal() {
            return this.len/3;
        }
    }
}
