package com.nwshire.coderbyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathChallengeTest {

    @Test
    public void mathChallenge() {
        int result = MathChallenge.mathChallenge(3975910);
        assertEquals(97, result);

        result = MathChallenge.mathChallenge(2064598872);
        assertEquals(98, result);
    }
}