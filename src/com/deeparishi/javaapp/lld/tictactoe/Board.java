package com.deeparishi.javaapp.lld.tictactoe;

public class Board {

    private final int row;
    private final int col;
    private char[][] board;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new char[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++)
                board[r][c] = '_';
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}