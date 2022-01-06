package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        final int[] answer = new int[2];
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                answer[0] = i;
                answer[1] = map.get(target - nums[i]);
                if (answer[0] > answer[1]) { // maintaining order for the sake of unit tests.
                    answer[0] = answer[1];
                    answer[1] = i;
                }
                return answer;
            }
            map.put(nums[i], i);
        }

        return answer;
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9));

        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6));

        assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{3, 3}, 6));
    }
}
