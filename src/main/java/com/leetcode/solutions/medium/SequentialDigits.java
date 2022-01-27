package com.leetcode.solutions.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 <a href="https://leetcode.com/problems/sequential-digits/">1291. Sequential Digits</a>
 <br/>
 An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 <br/><br/>
 Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 <pre>
 Constraints:

 10 <= low <= high <= 10^9
 </pre>
 */
public class SequentialDigits {
    public List<Integer> sequentialDigits(final int low, final int high) {
        final List<Integer> list = new LinkedList<>();
        final String numbers = "1234567890";

        int n = low;
        int width = 0;
        while (n > 0) {
            width++;
            n = n / 10;
        }

        int num = low;
        int start = 0;

        while (num <= high) {
            num = Integer.valueOf(numbers.substring(start, start + width));
            if (num >= low && num <= high) {
                list.add(num);
            }
            start++;
            if (start + width == 10) {
                start = 0;
                width++;
            }
        }
        return list;
    }

    @Test
    public void test() {
        assertEquals(List.of(123, 234), sequentialDigits(100, 300));
        assertEquals(List.of(12, 23, 34, 45), sequentialDigits(10, 50));
        assertEquals(List.of(), sequentialDigits(10, 11));
        assertEquals(List.of(123, 234), sequentialDigits(123, 234));
    }
}
