package org.example.dsa;

import java.util.HashSet;

public class SudokuValidator {

    public static boolean isValidSudoku(char[][] board) {
        // Create sets to track seen numbers in rows, columns, and subgrids
        HashSet<String> seen = new HashSet<>();

        // Traverse the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char current = board[i][j];

                // If the cell is not empty ('.')
                if (current != '.') {
                    // Create keys for row, column, and subgrid
                    String rowKey = "row" + i + current;
                    String colKey = "col" + j + current;
                    String subgridKey = "subgrid" + (i / 3) + (j / 3) + current;

                    // Check if the number already exists in the row, column, or subgrid
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(subgridKey)) {
                        return false;
                    }
                }
            }
        }

        // If no duplicates found, the board is valid
        return true;
    }


    public static boolean validSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];

        for(int i = 0 ; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char val = board[i][j];

                if(val == '.') {
                    continue;
                }

                int num = val -  '1';
                int gridIndex = i / 3 * 3 + j / 3;

                if(row[i][num] || column[j][num] || grid[gridIndex][num]) {
                    return false;
                }

                row[i][num] = true;
                column[j][num] = true;
                grid[gridIndex][num] = true;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '8', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        if (validSudoku(board)) {
            System.out.println("The Sudoku board is valid.");
        } else {
            System.out.println("The Sudoku board is not valid.");
        }
    }
}
