package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 <a href="https://leetcode.com/problems/remove-element/">27. Remove Element</a>
 Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 <br/><br/>
 Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 <br/><br/>
 Return k after placing the final result in the first k slots of nums.
 <br/>
 Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 <br/><br/>
 Custom Judge:
 <br/>
 The judge will test your solution with the following code:
 <pre>
 int[] nums = [...]; // Input array
 int val = ...; // Value to remove
 int[] expectedNums = [...]; // The expected answer with correct length.
 // It is sorted with no values equaling val.

 int k = removeElement(nums, val); // Calls your implementation

 assert k == expectedNums.length;
 sort(nums, 0, k); // Sort the first k elements of nums
 for (int i = 0; i < actualLength; i++) {
 assert nums[i] == expectedNums[i];
 }
 </pre>
 If all assertions pass, then your solution will be accepted.
 <br/><br/>
 <pre>
 Constraints:

 0 <= nums.length <= 100
 0 <= nums[i] <= 50
 0 <= val <= 100
 </pre>
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        int writePtr = 0;
        for (int num: nums) {
            if (num == val) {
                k--;
            } else {
                nums[writePtr++] = num;
            }
        }
        return k;
    }

    @Test
    public void test1() {
        int[] input = new int[]{3, 2, 2, 3};
        assertEquals(2, removeElement(input, 3));
        assertArrayEquals(new int[]{2,2}, Arrays.copyOf(input, 2));
    }

    @Test
    public void test2() {
        int[] input =  new int[]{0,1,2,2,3,0,4,2};
        assertEquals(5, removeElement(input, 2));
        assertArrayEquals(new int[]{0,1,3,0,4}, Arrays.copyOf(input, 5));
    }
}
