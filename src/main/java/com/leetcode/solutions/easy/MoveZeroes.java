package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 <a href="https://leetcode.com/problems/move-zeroes/submissions/">283. Move Zeroes</a>
 Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 <br/>
 Note that you must do this in-place without making a copy of the array.
 <br/>
 <pre>
 Constraints:

 1 <= nums.length <= 104
 -231 <= nums[i] <= 231 - 1
 </pre>
 Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        if (nums.length == 1) {
            return;
        }

        int writePtr = 0;
        for (int readPtr = 0; readPtr < nums.length; readPtr++) {
            if (nums[readPtr] != 0) {
                nums[writePtr] = nums[readPtr];
                writePtr++;
            }
        }

        for (int readPtr = writePtr; readPtr < nums.length; readPtr++) {
            nums[readPtr] = 0;
        }

    }

    @Test
    public void testMoveZerosExample1() {
        int[] input = {0,1,0,3,12};
        moveZeroes(input);
        assertArrayEquals(new int[]{1,3,12,0,0}, input);
    }

    @Test
    public void testMoveZerosExample2() {
        int[] input = {0};
        moveZeroes(input);
        assertArrayEquals(new int[]{0}, input);
    }

}
