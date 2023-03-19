package com.leetcode.solutions.easy.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 <a href="https://leetcode.com/problems/check-if-n-and-its-double-exist"/>1346. Check If N and Its Double Exist</a>
 <br/>
 Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 <br/><br/>
 More formally check if there exists two indices i and j such that :
 <pre>
 i != j
 0 <= i, j < arr.length
 arr[i] == 2 * arr[j]
 </pre>
 <pre>
 Constraints:

 2 <= arr.length <= 500
 -10^3 <= arr[i] <= 10^3
 </pre>
 */
public class CheckIfAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        final Set<Integer> set = new HashSet<>(arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] * 2) || arr[i] % 2 == 0 && set.contains(arr[i] / 2)) { // Why we need num % 2 == 0 here?
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public boolean checkIfExistBinarySearch(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (Arrays.binarySearch(arr, i + 1, arr.length, arr[i] * 2) > -1) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testCheckIfExist() {
        assertTrue(checkIfExist(new int[]{10, 2, 5, 3}));
        assertTrue(checkIfExist(new int[]{7, 1, 14, 11}));

        assertFalse(checkIfExist(new int[]{1, 3, 4, 21}));
        assertFalse(checkIfExist(new int[]{3, 1, 7, 11}));
    }

    @Test
    public void testCheckIfExistBinarySearch() {
        assertTrue(checkIfExistBinarySearch(new int[]{10, 2, 5, 3}));

        assertTrue(checkIfExistBinarySearch(new int[]{7, 1, 14, 11}));

        assertFalse(checkIfExistBinarySearch(new int[]{3, 1, 7, 11}));
    }

}
