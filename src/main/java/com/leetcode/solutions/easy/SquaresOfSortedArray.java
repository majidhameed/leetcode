package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 * </p><br/>
 * <p>
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 * </p>
 */
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {

        final int n = nums.length;

        if (n == 1) {
            return new int[]{nums[0] * nums[0]};
        }

        final int[] output = new int[n];

        int left;
        int right;

        int leftPtr = 0;
        int rightPtr = n - 1;

        int index = n - 1; // start placing elements to the end.

        while (index >= 0) {
            left = nums[leftPtr];
            right = nums[rightPtr];

            if (left * left > right * right) {
                output[index] = left * left;
                leftPtr++;
            } else {
                output[index] = right * right;
                rightPtr--;
            }
            index--;
        }

        return output;
    }


    @Test
    public void test() {
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));

        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }

}
