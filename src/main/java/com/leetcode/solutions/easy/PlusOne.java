package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.com/problems/plus-one/">66. Plus One</a>
 * <p>
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * </p>
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * </p>
 * <p>
 * Constraints:
 * </p>
 * <p>
 * 1 <= digits.length <= 100
 * </p>
 * <p>
 * 0 <= digits[i] <= 9
 * </p>
 * <p>
 * digits does not contain any leading 0's.
 * </p>
 */
public class PlusOne {

    public int[] plusOne(final int[] digits) {

        int sum;
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            if (sum != 10) {
                carry = 0;
            } else {
                carry = 1;
                sum = 0; // the max sum can go is 10
            }
            digits[i] = sum;
        }
        if (carry == 1) {
            final int[] res = new int[digits.length + 1];
            res[0] = carry;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }

    @Test
    public void testPlusOne() {
        assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));

        assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));

        assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));

        assertArrayEquals(new int[]{3, 0}, plusOne(new int[]{2, 9}));
    }

}
