package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 <a href="https://leetcode.com/problems/valid-mountain-array/">941. Valid Mountain Array</a>
 <br/>
 Given an array of integers arr, return true if and only if it is a valid mountain array.
 <br/>
 <pre>
 Recall that arr is a mountain array if and only if:

 arr.length >= 3

 There exists some i with 0 < i < arr.length - 1 such that:
 arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 </pre>

 <pre>
 Constraints:

 1 <= arr.length <= 104
 0 <= arr[i] <= 104
 </pre>
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {

        if (arr.length < 3) { // mountain has a peak left, middle, and right; at least 3 elements required
            return false;
        }

        int direction = 0; // start at ground

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) { // plateau
                return false;
            } else if (arr[i] < arr[i + 1]) { // increasing
                if (direction == -1) { // started increasing again after decreasing
                    return false;
                }
                direction = 1;
            } else if (arr[i] > arr[i + 1]) { // decreasing
                if (direction == 0) { // started decreasing without increasing
                    return false;
                }
                direction = -1;
            }
        }

        return direction == -1; // must be decreasing in the end
    }

    @Test
    public void testValidMountainArray() {
        assertFalse(validMountainArray(new int[]{2, 1}));
        assertFalse(validMountainArray(new int[]{3, 5, 5}));
        assertTrue(validMountainArray(new int[]{0, 3, 2, 1}));
    }

}
