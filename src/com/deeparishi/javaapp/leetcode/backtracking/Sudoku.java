package com.deeparishi.javaapp.leetcode.backtracking;

public class Sudoku {

    public static void main(String[] args) {
//        char[][] board = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };

        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };



        System.out.println("Starting Sudoku Solver with detailed logs:\n");
        printBoard(board);
        System.out.println("\n----------------------------\n");

        boolean solved = validSudoku(board);
        if (!solved)
            System.out.println("❌ Sudoku cannot be solved.");
        printBoard(board);
    }

    public static boolean validSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // find an empty cell
                if (board[row][col] == '.') {

                    for (char c = '1'; c <= '9'; c++) {

                        // check if it's valid to place c
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;  // place it
                            System.out.printf("Placed %c at (%d, %d)%n", c, row, col);

                            // recursively try to solve
                            if (validSudoku(board))
                                return true;

                            // if not solvable, reset and try next number
                            System.out.printf("Backtracking from (%d, %d), removing %c%n", row, col, c);
                            board[row][col] = '.';
                        }
                    }

                    // if no number fits, trigger backtrack
                    return false;
                }
            }
        }

        // if no empty cell left, board is solved
        System.out.println("\n✅ Final Solved Sudoku Board:");
        printBoard(board);
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // row check
            if (board[i][col] == c) return false; // col check

            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false; // 3x3 box check
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println("------+-------+------");

            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print(STR."\{board[i][j]} ");
            }
            System.out.println();
        }
    }
}
