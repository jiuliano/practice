package com.nwshire;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/20/2017.
 */
public class BowlingScorerTest {
    @Test
    public void roll() throws Exception {
        BowlingScorer bs = new BowlingScorer();

        while ( true ) {
            if ( !bs.roll(10) ) break;
        }

        int score = bs.score();
        assertEquals(score, 300);

        bs = new BowlingScorer();
        while ( true ) {
            if ( !bs.roll(9) ) break;
            if ( !bs.roll(1) ) break;
        }

        score = bs.score();
        assertEquals(score, 190);

        bs = new BowlingScorer();
        while ( true ) {
            if ( !bs.roll(0) ) break;
            if ( !bs.roll(10) ) break;
        }

        score = bs.score();
        assertEquals(score, 100);

        bs = new BowlingScorer();
        while ( true ) {
            if ( !bs.roll(4) ) break;
        }

        score = bs.score();
        assertEquals(score, 80);

        bs = new BowlingScorer();
        while ( true ) {
            if ( !bs.roll(4) ) break;
            if ( !bs.roll(4) ) break;
            if ( !bs.roll(5) ) break;
            if ( !bs.roll(5) ) break;
        }

        score = bs.score();
        assertEquals(score, 110);
    }
}