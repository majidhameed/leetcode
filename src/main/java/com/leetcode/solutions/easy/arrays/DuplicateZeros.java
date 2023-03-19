package com.leetcode.solutions.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.com/problems/duplicate-zeros/">1089. Duplicate Zeros</a>
 * <p>
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * </p>
 * <p>
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 * </p>
 *
 * <p>
 * Constraints:
 * </p>
 * <p>
 * 1 <= arr.length <= 104
 * </p>
 * <p>
 * 0 <= arr[i] <= 9
 * </p>
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) { // found zero
                for (int j = arr.length - 1; j > i; j--) { // start from the end and move each element to its right
                    arr[j] = arr[j - 1]; // move left element to the right
                }
                i++;
            }
        }
    }

    @Test
    public void test1() {
        int[] input = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(input);
        assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, input);
    }

    @Test
    public void test2() {
        int[] input = new int[]{1, 2, 3};
        duplicateZeros(input);
        assertArrayEquals(new int[]{1, 2, 3}, input);
    }
}
