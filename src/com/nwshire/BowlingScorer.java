package com.nwshire;

import java.util.Arrays;
import java.util.Stack;
import java.util.jar.Pack200;

/**
 * Created by james on 1/20/2017.
 */
public class BowlingScorer {
    private Frame game[] = new Frame[10];
    private int toScoreIdx = 0;
    private int frameIdx = 0;

    BowlingScorer() {
        for ( int n=0; n<game.length; n++ ) {
            game[n] = new Frame();
        }
    }

    public boolean roll(int pins) {
        boolean rollTaken = false;

        if ( frameIdx < game.length && game[frameIdx].frameDone(frameIdx) ) {
            ++frameIdx;
        }

        if ( frameIdx < game.length) {
            rollTaken = true;
            game[frameIdx].roll(pins);

            for ( int fi=toScoreIdx; fi<=frameIdx; fi++ ) {
                if ( !game[fi].scoreDone() ) {
                    int lastScore = fi > 0 ? game[fi-1].score : 0;
                    int nfi = fi + 1;

                    if ( game[fi].isStrike() ) {
                        int rolls[] = getNextRolls(2, nfi, frameIdx);
                        if ( rolls.length >= 2 ) {
                            game[fi].score = lastScore + 10 + rolls[0] + rolls[1];
                            ++toScoreIdx; // frame scored.
                        }
                    } else if ( game[fi].isSpare() ) {
                        int rolls[] = getNextRolls(1, nfi, frameIdx);
                        if ( rolls.length >= 1 ) {
                            game[fi].score = lastScore + 10 + rolls[0];
                            ++toScoreIdx;
                        }
                    } else if ( game[fi].rollsDone() ) {
                        game[fi].score = lastScore + game[fi].rolls[0] + game[fi].rolls[1];
                    }
                }
            }
        }

        return rollTaken;
    }

    private int[] getNextRolls(int numRolls, int frameIdx, int lastFrame) {
        int rolls[] = new int[2];
        int rollIdx = 0;

        while ( rollIdx < numRolls && frameIdx<=lastFrame ) {
            for ( int x=0; x<game[frameIdx].roll; x++ ) {
                rolls[rollIdx++] = game[frameIdx].rolls[x];
            }

            ++frameIdx;
        }

        return Arrays.copyOfRange(rolls, 0, rollIdx);
    }

    public int score() {
        int finalScore = -1;

        if ( game[9].frameDone(9) ) {
            finalScore = game[8].score + game[9].rolls[0] + game[9].rolls[1];

            if ( game[9].isSpare() || game[9].isStrike() ) {
                finalScore += game[9].rolls[2];
            }
        }

        return finalScore;
    }

    private class Frame {
        int score = -1;
        int rolls[] = new int[] { 0, 0, 0 };
        int roll = 0;

        Frame() {
        }

        void roll(int pins) {
            if ( roll < rolls.length )
                rolls[roll++] = pins;
        }

        boolean rollsDone() {
            return roll == 2 || pinsDown() == 10;
        }

        boolean scoreDone() {
            return score > -1;
        }

        boolean frameDone(int frameIdx) {
            boolean done = rollsDone();

            if ( frameIdx == 9 && (isStrike() || isSpare()) ) {
                done = roll == 3;
            } else {
                done = rollsDone();
            }

            return done;
        }

        int pinsDown() {
            return rolls[0] + rolls[1];
        }

        int numRolls() {
            return roll;
        }

        boolean isStrike() {
            return rolls[0] == 10;
        }

        boolean isSpare() {
            return !isStrike() && pinsDown() == 10;
        }
    }
}
