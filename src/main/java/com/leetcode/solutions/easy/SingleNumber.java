package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/single-number/">136. Single Number</a>
 * <p>
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * </p><br/>
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * </p>
 */
public class SingleNumber {
    public int singleNumber(final int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i]; // numbers appearing twice xor'ed will cancel each other.
        }

        return ans;
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, singleNumber(new int[]{2, 2, 1}));

        assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));

        assertEquals(1, singleNumber(new int[]{1}));
    }
}
