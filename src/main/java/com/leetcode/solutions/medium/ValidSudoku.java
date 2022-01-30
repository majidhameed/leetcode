package com.leetcode.solutions.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 <a href="https://leetcode.com/problems/valid-sudoku/">36. Valid Sudoku</a>
 Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 <br/><br/>
 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 <br/><br/>
 Note:
 <br/>
 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 <pre>
 Constraints:

 board.length == 9
 board[i].length == 9
 board[i][j] is a digit 1-9 or '.'.
 </pre>
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<String> set = new HashSet<>();
        char ch;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                ch = board[row][col];
                if (ch != '.') {
                    if (
                            !set.add(ch + " row:" + row) ||
                                    !set.add(ch + " col:" + col) ||
                                    !set.add(ch + " " + (int) row / 3 + "x" + (int) col / 3)
                    ) {
                        return false;
                    }
                }

            }

        }
        return true;
    }

    @Test
    public void testTrueCaseIsValidSudoku() {
        assertTrue(isValidSudoku(new char[][]{
                 {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));

    }

    @Test
    public void testFalseCaseIsValidSudoku() {
        assertFalse(isValidSudoku(new char[][] {
                 {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
                }));
    }


}
