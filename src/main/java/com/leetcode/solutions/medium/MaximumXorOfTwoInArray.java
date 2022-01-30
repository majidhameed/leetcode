package com.leetcode.solutions.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 <a href="https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/">421. Maximum XOR of Two Numbers in an Array</a>
 <br/>
 Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 <br/>
 <pre>
 Constraints:

 1 <= nums.length <= 2 * 105
 0 <= nums[i] <= 231 - 1
 </pre>
 */
public class MaximumXorOfTwoInArray {

    public int maxXorOfTwo(int[] nums) {
        final int[] uniqueNums = Arrays.stream(nums)
                .distinct()
                .toArray();
        int max = Integer.MIN_VALUE;
        int curr;
        for (int i = 0; i < uniqueNums.length; i++) {
            for (int j = i; j < uniqueNums.length; j++) {
                curr = uniqueNums[i] ^ uniqueNums[j];
                if (curr > max) {
                    max = curr;
                }
            }
        }
        return max;
    }

    @Test
    public void testMaxXorOfTwo() {
        assertEquals(28, maxXorOfTwo(new int[]{3, 10, 5, 25, 2, 8}));

        assertEquals(127,
                maxXorOfTwo(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }
}
