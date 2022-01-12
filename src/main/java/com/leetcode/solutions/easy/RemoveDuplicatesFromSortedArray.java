package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">26. Remove Duplicates from Sorted Array</a>
 * <br/>
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <br/>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <br/>
 * Return k after placing the final result in the first k slots of nums.
 * <br/>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <br/><br/>
 * Custom Judge:
 * <br/>
 * The judge will test your solution with the following code:
 * <pre>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * </pre>
 * If all assertions pass, then your solution will be accepted.
 * <pre>
 * Constraints:
 *
 * 0 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 * </pre>
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int uniq = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[uniq] != nums[i]) {
                nums[++uniq] = nums[i];
            }
        }
        return uniq + 1;
    }

    @Test
    public void test1() {
        int[] input = new int[]{1, 1, 2};
        removeDuplicates(input);
        assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(input, 2));
    }

    @Test
    public void test2() {
        int[] input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(input);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, Arrays.copyOf(input, 5));
    }


}
