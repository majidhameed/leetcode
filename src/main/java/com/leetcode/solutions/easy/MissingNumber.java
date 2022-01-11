package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/missing-number/">268. Missing Number</a>
 *
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * </p>
 * <p>
 * Constraints:
 * </p>
 * <p>
 * n == nums.length
 * </p>
 * <p>
 * 1 <= n <= 104
 * </p>
 * <p>
 * 0 <= nums[i] <= n
 * </p>
 * <p>
 * All the numbers of nums are unique.
 * </p>
 * <p>
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 * </p>
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        return (n*n + n) / 2 - sum; // n * (n+1) / 2
    }

    @Test
    public void test() {
        assertEquals(2, missingNumber(new int[]{3, 0, 1}));

        assertEquals(2, missingNumber(new int[]{0, 1}));

        assertEquals(8, missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));

    }
}
