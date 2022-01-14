package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">88. Merge Sorted Array</a>
 * <br/><br/>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <br/><br/>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <br/><br/>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <pre>
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * </pre>
 * <br/>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class MergeSortedArray {

    public void merge(final int[] bigArray, final int bigArrayCount, final int[] smallArray, final int smallArrayCount) {

        int bigArrayPtr = bigArrayCount - 1;
        int smallArrayPtr = smallArrayCount - 1;
        int notProcessedCount = bigArrayCount + smallArrayCount - 1;

        while (notProcessedCount >= 0) {
            if (smallArrayPtr < 0 || (bigArrayPtr >= 0 && bigArray[bigArrayPtr] > smallArray[smallArrayPtr])) {
                bigArray[notProcessedCount--] = bigArray[bigArrayPtr--]; // take from big array from the end
            } else {
                bigArray[notProcessedCount--] = smallArray[smallArrayPtr--]; // take from small array from the end
            }
        }
    }

    @Test
    public void test1() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    public void test2() {
        int[] nums1 = new int[]{1};
        merge(nums1, 1, new int[]{}, 0);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void test3() {
        int[] nums1 = new int[]{0};
        merge(nums1, 0, new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, nums1);
    }

}
