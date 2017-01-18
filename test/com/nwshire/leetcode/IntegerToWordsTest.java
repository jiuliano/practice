package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/17/2017.
 */
public class IntegerToWordsTest {
    @Test
    public void numberToWords() throws Exception {
        IntegerToWords itw = new IntegerToWords();

        /*
        itw.numberToWords(1123345678);
        itw.numberToWords(0);
        itw.numberToWords(1);
        itw.numberToWords(100000000);
        itw.numberToWords(100013001);
        itw.numberToWords(12013);
        itw.numberToWords(20);
        */
        itw.numberToWords(1000010);
    }
}