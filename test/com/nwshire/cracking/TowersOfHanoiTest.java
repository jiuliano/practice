package com.nwshire.cracking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/21/2017.
 */
public class TowersOfHanoiTest {
    @Test
    public void run() throws Exception {
        TowersOfHanoi toh = new TowersOfHanoi();
        toh.run(5);
    }

}