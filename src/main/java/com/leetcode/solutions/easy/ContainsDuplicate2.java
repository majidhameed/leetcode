package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 <a href="https://leetcode.com/problems/contains-duplicate-ii/">219. Contains Duplicate II</a>
 <br/>
 Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that
 nums[i] == nums[j] and abs(i - j) <= k.
 <pre>
 Constraints:

 1 <= nums.length <= 105
 -109 <= nums[i] <= 109
 0 <= k <= 105
 </pre>
 */
public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(final int[] nums, final int k) {

        final Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                final List<Integer> list = map.get(nums[i]); // stored indices for a number
                for (int j: list) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }

                list.add(i);
                map.put(nums[i], list);
            } else {
                final List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(nums[i],list);
            }
        }

        return false;
    }

    @Test
    public void test() {
        assertTrue(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));

        assertTrue(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));

        assertFalse(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
