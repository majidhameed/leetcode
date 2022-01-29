package com.leetcode.solutions.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 <a href="https://leetcode.com/problems/count-primes/">204. Count Primes</a>
 <br/>
 Given an integer n, return the number of prime numbers that are strictly less than n.
<pre>
 Constraints:

 0 <= n <= 5 * 106
</pre>
 */
public class CountPrimes {

    public int countPrimes(final int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        final boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }

        return count;
    }


    @Test
    public void testCountPrimes() {
        assertEquals(4, countPrimes(10));
        assertEquals(0, countPrimes(0));
        assertEquals(0, countPrimes(0));
    }

}
