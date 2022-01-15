package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/majority-element/">169. Majority Element</a>
 * <br/>
 * Given an array nums of size n, return the majority element.
 * <br/> <br/>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <pre>
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 * </pre>
 * <br/>
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        final Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
        int frequency = Integer.MIN_VALUE;
        int target = nums[0];
        for (int num : nums) {
            if (numberFrequencyMap.containsKey(num)) {
                numberFrequencyMap.put(num, numberFrequencyMap.get(num) + 1);
                if (numberFrequencyMap.get(num) > nums.length / 2) {
                    return num;
                }
            } else {
                numberFrequencyMap.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : numberFrequencyMap.entrySet()) {
            if (frequency < entry.getValue()) {
                target = entry.getKey();
                frequency = entry.getValue();
            }
        }

        return target;
    }

    @Test
    public void test() {
        assertEquals(3, majorityElement(new int[]{3, 2, 3}));

        assertEquals(2, majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
