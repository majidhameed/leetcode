package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/">
 * 299. Replace Elements with Greatest Element on Right Side</a>
 * <br/><br/>
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * <br/><br/>
 * After doing so, return the array.
 * <pre>
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 105
 * </pre>
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public int[] replaceElements(final int[] arr) {
        final int n = arr.length;

        if (n == 1) {
            arr[0] = -1;
            return arr;
        }

        int max = 0;
        int maxIndex = 0;
        int startIndex = 0;

        while (startIndex < n) {
            for (int i = n - 1; i >= startIndex; i--) { // find Max from end to start or start of maxIndex+1
                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                } else {
                    arr[i] = max;
                }
            }
            if (startIndex != 0) {
                arr[startIndex - 1] = max;
            }
            startIndex = maxIndex + 1; // elements on the right of max already replaced.
            max = 0;
        }
        arr[n - 1] = -1;

        return arr;
    }

    /**
     * Brute force version
     * @param arr
     * @return
     */
    public int[] replaceElementsBruteForce(int[] arr) {
        int n = arr.length;
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            arr[i] = max;
        }
        arr[n - 1] = -1;
        return arr;
    }

    @Test
    public void testReplaceElements() {
        assertArrayEquals(new int[]{18, 6, 6, 6, 1, -1}, replaceElements(new int[]{17, 18, 5, 4, 6, 1}));
        assertArrayEquals(new int[]{-1}, replaceElements(new int[]{400}));
    }
}
