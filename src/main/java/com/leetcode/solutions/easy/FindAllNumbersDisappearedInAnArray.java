package com.leetcode.solutions.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">448. Find All Numbers Disappeared in an Array</a>
 * <br/>
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <pre>
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * </pre>
 * <br/>
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbersSetApproach(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(i + 1);
            set.remove(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }

        return List.copyOf(set);
    }

    public List<Integer> findDisappearedNumbersSortApproach(int[] nums) {
        List<Integer> list = new LinkedList<>();

        Arrays.parallelSort(nums);

        for (int i = 1; i <= nums.length; i++) {
            if (Arrays.binarySearch(nums, i) < 0) {
                list.add(i);
            }
        }

        return list;
    }

    @Test
    public void testFindDisappearedNumbersSetApproach() {
        assertEquals(List.of(5, 6), findDisappearedNumbersSetApproach(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        assertEquals(List.of(2), findDisappearedNumbersSetApproach(new int[]{1, 1}));
        assertEquals(List.of(6, 8), findDisappearedNumbersSetApproach(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7}));
    }

    @Test
    public void testFindDisappearedNumbersSortApproach() {
        assertEquals(List.of(5, 6), findDisappearedNumbersSortApproach(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        assertEquals(List.of(2), findDisappearedNumbersSortApproach(new int[]{1, 1}));
        assertEquals(List.of(6, 8), findDisappearedNumbersSortApproach(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7}));
    }

}
