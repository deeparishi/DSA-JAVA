package com.deeparishi.javaapp.lld.tictactoe;

import java.util.Map;
import java.util.Objects;

public class Board {

    private final String[][] BOARD;

    public Board(int row, int col) {
        this.BOARD = new String[row][col];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                BOARD[i][j] = "-";
        }
    }

    public Map<String, Object> play(int row, int col, String choice) {

        if (!isValidMove(row, col))
            return Map.of("status", false,
                    "message", " does not moved a valid position");

        if (!Objects.equals(BOARD[row][col], "-"))
            return Map.of("status", false,
                    "message", STR.", it was already occupied with \{BOARD[row][col]}");

        BOARD[row][col] = choice;

        if (checkWinner(row, col, choice))
            return Map.of("status", true,
                    "message", " Won the match!, Congratulations");

        return Map.of("status", true,
                "message", " your move is marked");
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && col >= 0 && row < 3 && col < 3;
    }

    public boolean checkWinner(int row, int col, String choice) {

        boolean vertical = true;
        boolean horizontal = true;
        boolean diagonal = true;
        boolean antiDiagonal = true;

        for (int i = 0; i < 3; i++) {

            if (!BOARD[row][i].equals(choice))
                horizontal = false;

            if (!BOARD[i][col].equals(choice))
                vertical = false;

            if (!BOARD[i][i].equals(choice))
                diagonal = false;

            if (!BOARD[i][2 - i].equals(choice))
                antiDiagonal = false;
        }

        return horizontal || vertical || diagonal || antiDiagonal;
    }
}