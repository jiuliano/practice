package com.nwshire.coderbyte;

import java.util.ArrayList;
import java.util.List;


public class PrimeTime {

    private static List<Integer> primes = new ArrayList<>();
    private static int[] ip = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
    private static int lp = 97;

    static {
        for (int i : ip)
            primes.add(i);
    }

    public static String PrimeTime(int num) {
        while (lp < num)
            lp = nextPrime();

        return primes.contains(Integer.valueOf(num)) ? "true" : "false";
    }

    private static int nextPrime() {
        int np = lp + 1;

        while (!isPrime(np)) np++;
        primes.add(np);
        return np;
    }

    private static boolean isPrime(int np) {
        for (int p : primes) {
            if (np % p == 0)
                return false;
        }

        return true;
    }
}
