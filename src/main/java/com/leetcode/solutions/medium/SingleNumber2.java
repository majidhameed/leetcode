package com.leetcode.solutions.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/single-number-ii/">137. Single Number II</a>
 * <br/>
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 * <br/>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * <pre>
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 * </pre>
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // NlogN + N = NlogN

        Arrays.sort(nums); // NlogN
        for (int i = 1; i < nums.length - 1; i++) { // N
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) { // non-repetitive must not match with a number before or after it
                return nums[i];
            }
        }
        // First two same ? it must be last otherwise it's the first.
        return nums[0] == nums[1] ? nums[nums.length - 1] : nums[0];
    }

    @Test
    public void testSingleNumber() {
        assertEquals(3, singleNumber(new int[]{2, 2, 3, 2}));
        assertEquals(1, singleNumber(new int[]{1, 2, 2, 2}));
        assertEquals(99, singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
