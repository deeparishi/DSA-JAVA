package com.deeparishi.javaapp.lld.tictactoe;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Player one = new Player("Rishi", "X");
        Player two = new Player("John", "Y");
        TicTacToeGame ticTacToeGame = new TicTacToeGame(List.of(one, two));
        ticTacToeGame.start();
    }
}
