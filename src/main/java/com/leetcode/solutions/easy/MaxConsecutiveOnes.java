package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 <a href="https://leetcode.com/problems/max-consecutive-ones/">485. Max Consecutive Ones</a>
 <br/>
 Given a binary array nums, return the maximum number of consecutive 1's in the array.
 <br/><br/>
 <pre>
 Constraints:

 1 <= nums.length <= 105
 nums[i] is either 0 or 1.
 </pre>
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curr++;
                if (curr > max) {
                    max = curr;
                }
            } else {
                curr = 0;
                if (max > i) {
                    return max;
                }
            }
        }
        return max;
    }


    @Test
    public void testExample1FindMaxConsecutiveOnes() {
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    @Test
    public void testExample2FindMaxConsecutiveOnes() {
        assertEquals(2, findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }
}
