package com.deeparishi.javaapp.leetcode.arrays;

// https://leetcode.com/problems/available-captures-for-rook/submissions

public class AvailableCapturesForRook {

    public static void main(String[] args) {

        char[][] matrix1 = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(numRookCaptures(board));
//        System.out.println(numRookCaptures(matrix1));
    }

    public static int numRookCaptures(char[][] board) {

        int[] rookPos = new int[2];

        for (int i = 0; i < board.length; i++) {
            boolean flag = false;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    rookPos = new int[]{i, j};
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        int[] count = new int[1];
        moveUp(rookPos[0], rookPos[1], board, count);
        moveDown(rookPos[0], rookPos[1], board, count);
        moveLeft(rookPos[0], rookPos[1], board, count);
        moveRight(rookPos[0], rookPos[1], board, count);

        return count[0];
    }

    private static void moveUp(int row, int col, char[][] board, int[] count) {

        if(row < 0 || board[row][col] == 'B')
            return;
        if(board[row][col] == 'p' || board[row][col] == 'P') {
            count[0]++;
            return;
        }
        moveUp(row - 1, col, board, count);

    }

    private static void moveDown(int row, int col, char[][] board, int[] count) {

        if((row >= board.length) || board[row][col] == 'B')
            return;
        if(board[row][col] == 'p' || board[row][col] == 'P') {
            count[0]++;
            return;
        }
        moveDown(row + 1, col, board, count);
    }

    private static void moveLeft(int row, int col, char[][] board, int[] count) {

        if(col < 0 || board[row][col] == 'B')
            return;
        if(board[row][col] == 'p' || board[row][col] == 'P') {
            count[0]++;
            return;
        }
        moveLeft(row, col - 1, board, count);
    }

    private static void moveRight(int row, int col, char[][] board, int[] count) {

        if( col >= board.length || board[row][col] == 'B')
            return;
        if(board[row][col] == 'p' || board[row][col] == 'P') {
            count[0]++;
            return;
        }
            moveRight(row , col + 1, board, count);
    }
}

