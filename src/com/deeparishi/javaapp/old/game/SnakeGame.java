package com.deeparishi.javaapp.old.game;

import java.util.Arrays;

public class SnakeGame {


    public static void game(String p, int r, int c) {
        if (r == 3 && c == 3) {
            System.out.println(p);
        }
        if (r < 3 && c < 3) {
            game(p + 'V', r - 1, c - 1);
        }
        if (r > 1) {
            game(p + 'D', r - 1, c);

        }
        if (c > 1) {
            game(p + 'R', r, c - 1);
        }
    }

    public static void games(String p, int r, int c) {
        if (r == 3 && c == 3) {
            System.out.println(p);
        }
        if (r < 3 && c < 3) {
            games(p + 'V', r + 1, c + 1);
        }
        if (r < 3) {
            games(p + 'D', r + 1, c);

        }
        if (c < 3) {
            games(p + 'R', r, c + 1);
        }
    }


    public static void Backtracking(String p, boolean[][] board, int row, int col, int[][] path, int step) {
        if (row == 2 && col == 2) {
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
        }
        if (!board[row][col]) {
            return;
        }
        board[row][col] = false;
        path[row][col] = step;
        if (row < board.length - 1) {
            Backtracking(p + 'D', board, row + 1, col, path, step + 1);
        }
        if (col < board[0].length - 1) {
            Backtracking(p + 'R', board, row, col + 1, path, step + 1);
        }
        if (row > 0) {
            Backtracking(p + 'U', board, row - 1, col, path, step + 1);
        }
        if (col > 0) {
            Backtracking(p + 'L', board, row, col - 1, path, step + 1);
        }
        board[row][col] = true;
        path[row][col] = 0;
    }
}

