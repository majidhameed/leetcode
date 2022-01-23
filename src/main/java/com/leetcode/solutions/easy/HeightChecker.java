package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 <a href="https://leetcode.com/problems/height-checker/">1051. Height Checker</a>
 <br/><br/>
 A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 <br/><br/>
 You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
 <br/><br/>
 Return the number of indices where heights[i] != expected[i].
 <br/><br/>
 <pre>
 Constraints:

 1 <= heights.length <= 100
 1 <= heights[i] <= 100
 </pre>
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {

        int k = 0;
        final int n = heights.length;
        final int[] sorted = new int[n];

        System.arraycopy(heights, 0, sorted, 0, n);
        Arrays.parallelSort(sorted);

        for (int i = 0; i < n; i++) {
            if (heights[i] != sorted[i]) {
                k++;
            }
        }

        return k;
    }

    @Test
    public void testHeightChecker() {
        assertEquals(3, heightChecker(new int[]{1,1,4,2,1,3}));

        assertEquals(5, heightChecker(new int[]{5,1,2,3,4}));

        assertEquals(0, heightChecker(new int[]{1,2,3,4,5}));
    }

}
