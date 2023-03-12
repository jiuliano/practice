package com.nwshire.coderbyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTwoTest {

    @Test
    public void palindromeTwo() {
        String result = PalindromeTwo.PalindromeTwo("Noel - sees Leon");
        assertEquals("true", result);

        result = PalindromeTwo.PalindromeTwo("A war at Tarawa!");
        assertEquals("true", result);

        result = PalindromeTwo.PalindromeTwo("The gray fix jumped over the blue fence.");
        assertEquals("false", result);

        result = PalindromeTwo.PalindromeTwo("racecar");
        assertEquals("true", result);

        result = PalindromeTwo.PalindromeTwo("e");
        assertEquals("true", result);
    }
}