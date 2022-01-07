package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input Array Is Sorted</a>
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */
public class TwoSum2_InputArrayIsSorted {
    public int[] twoSum(final int[] numbers, final int target) {
        final int[] res = {1, 2};

        if (numbers.length == 2) {
            return res;
        }

        int j;
        for (int i = 0; i < numbers.length; i++) {
            j = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (j > 0) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
        }
        return res;
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));

        assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6));

        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
    }
}
