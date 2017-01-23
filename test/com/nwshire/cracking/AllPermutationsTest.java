package com.nwshire.cracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by james on 1/22/2017.
 */
public class AllPermutationsTest {
    @Test
    public void allPermutations() throws Exception {
        AllPermutations ap = new AllPermutations();

        List<String> permutations = ap.allPermutations("cab");
    }

}