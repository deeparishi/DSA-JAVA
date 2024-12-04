package com.deeparishi.javaapp.leetcode.graph;

import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        // Traverse first and last row, row as j -> col
        for (int j = 0; j < col; j++) {

            // First row
            if (board[0][j] == 'O' && !visited[0][j])
                dfs(0, j, board, visited, dRow, dCol);
            // Second row
            if (board[row - 1][j] == 'O' && !visited[row - 1][j])
                dfs(row - 1, j, board, visited, dRow, dCol);
        }

        // Traverse first and last col, col as j -> row
        for (int i = 0; i < row; i++) {

            // First col
            if (board[i][0] == 'O' && !visited[i][0])
                dfs(i, 0, board, visited, dRow, dCol);

            //// second col
            if (board[i][col - 1] == 'O' && !visited[i][col - 1])
                dfs(i, col - 1, board, visited, dRow, dCol);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    private static void dfs(int row, int col, char[][] board,
                            boolean[][] visited, int[] dRow, int[] dCol) {

        visited[row][col] = true;

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols &&
                    board[nRow][nCol] == 'O' && !visited[nRow][nCol]) {
                dfs(nRow, nCol, board, visited, dRow, dCol);
            }
        }
    }
}
