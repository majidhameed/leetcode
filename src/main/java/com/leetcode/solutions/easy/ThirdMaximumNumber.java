package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/third-maximum-number/">414. Third Maximum Number</a>
 * <br/>
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 * <br/><br/>
 * <pre>
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * </pre>
 *
 * Follow up: Can you find an O(n) solution?
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {

        final Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int num: nums) {
            set.add(num);
        }

        int i = 0;
        for (int num : set) {
            if (++i == 3) {
                return num;
            }
        }

        return set.iterator().next();
    }

    @Test
    public void testThirdMax() {

        assertEquals(1, thirdMax(new int[]{3, 2, 1}));

        assertEquals(2, thirdMax(new int[]{1, 2}));

        assertEquals(1, thirdMax(new int[]{2, 2, 3, 1}));
    }
}
