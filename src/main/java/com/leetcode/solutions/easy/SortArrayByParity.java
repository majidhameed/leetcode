package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 <a href="https://leetcode.com/problems/sort-array-by-parity/">905. Sort Array By Parity</a>
 Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 <br/>
 Return any array that satisfies this condition.
 <br/><br/>
<pre>
 Constraints:

 1 <= nums.length <= 5000
 0 <= nums[i] <= 5000
 </pre>
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int indexEvens = 0;
        int indexOdds = nums.length - 1;
        int tmp;

        while (indexEvens < indexOdds) {
            if (nums[indexEvens] % 2 == 0) { // even at start of start array
                indexEvens++;
            } else { // odd; move it to the end.
                tmp = nums[indexEvens]; // odd
                nums[indexEvens] = nums[indexOdds];
                nums[indexOdds] = tmp;
                indexOdds--;
            }
            if (nums[indexOdds] % 2 != 0) { // odd at end of array
                indexOdds--;
            }
        }
        return nums;
    }

    @Test
    public void testSortArrayByParity() {
        assertArrayEquals(new int[]{4,2,1,3}, sortArrayByParity(new int[]{3,1,2,4}));
    }
}
