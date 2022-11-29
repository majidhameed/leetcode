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
        // Sieve of Eratosthenes - https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
        final boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) { // Assume all numbers are prime except 0 and 1.
            primes[i] = true;
        }
        for (int i = 2; i * i < n; i++) { // only need to go up square of a number is less than n
            if (!primes[i]) { // already set as non-prime so check next one.
                continue;
            }
            for (int j = i * i; j < n; j += i) { // mark all composites as non-prime!
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
        assertEquals(0, countPrimes(1));
    }

}
