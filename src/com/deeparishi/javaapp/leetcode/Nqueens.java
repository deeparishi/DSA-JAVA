package com.deeparishi.javaapp.leetcode;

public class Nqueens {


    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }


    public static int queens(boolean[][] board, int rows) {
        if (rows == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, rows, col)) {
                board[rows][col] = true;
                count += queens(board, rows + 1);
                board[rows][col] = false;

            }
        }
        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        int maxRigth = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRigth; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }


    public static void display(boolean[][] board) {
        for (boolean[] rows : board) {
            for (boolean elements : rows) {
                if (elements) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }

            }
            System.out.println();
        }

    }
}
