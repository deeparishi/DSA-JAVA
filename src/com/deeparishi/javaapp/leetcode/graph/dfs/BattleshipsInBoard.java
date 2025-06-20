package com.deeparishi.javaapp.leetcode.graph.dfs;

// https://leetcode.com/problems/battleships-in-a-board

public class BattleshipsInBoard {

    public static void main(String[] args) {

    }


    public int countBattleships(char[][] board) {

        int rowLen = board.length;
        int colLen = board[0].length;
        char[][] boardCopy = new char[rowLen][colLen];
        for (int i = 0; i < rowLen; i++)
            System.arraycopy(board[i], 0, boardCopy[i], 0, colLen);

        int count = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(boardCopy[i][j] == 'X') {
                    count++;
                    dfs(i, j, rowLen, colLen, boardCopy);
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, int rowLen, int colLen, char[][] boardCopy) {

        if(row < 0 || row >= rowLen || col < 0  || col >= colLen || boardCopy[row][col] == '.')
            return;

        boardCopy[row][col] = '.';

        dfs(row + 1, col, rowLen, colLen, boardCopy); // Down
//        dfs(row - 1, col, rowLen, colLen, boardCopy); // Up
        dfs(row, col + 1, rowLen, colLen, boardCopy); // Right
//        dfs(row, col - 1, rowLen, colLen, boardCopy); // Left

    }
}
