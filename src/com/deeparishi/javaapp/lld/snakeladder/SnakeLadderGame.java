package com.deeparishi.javaapp.lld.snakeladder;

import com.deeparishi.javaapp.lld.snakeladder.model.Dice;
import com.deeparishi.javaapp.lld.snakeladder.model.Player;
import com.deeparishi.javaapp.lld.snakeladder.service.Board;
import com.deeparishi.javaapp.lld.snakeladder.service.GameService;

import java.util.*;

public class SnakeLadderGame {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        SnakeLadderGame game = new SnakeLadderGame();
        while (true) {
            printMenu();
            int option = nextInt("Choose any one option to start the game:");

            if (option == 0)
                break;

            switch (option) {
                case 1 -> game.playedBySystem();
                case 2 -> game.playWithMachine();
                case 3 -> game.playedByFriends();
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void playWithMachine() {
        List<Player> players = askPlayers(true);
        int diceCount = askDiceCount();
        int boardSize = askBoardSize();
        Dice dice = new Dice(diceCount);
        Board board = new Board(boardSize);
        board.loadLadder();
        board.loadSnake();
        GameService game = new GameService(board, dice, players);
        game.manualStart();
    }

    private void playedByFriends() {
        List<Player> players = askPlayers(false);
        int diceCount = askDiceCount();
        int boardSize = askBoardSize();
        Dice dice = new Dice(diceCount);
        Board board = new Board(boardSize);
        board.loadLadder();
        board.loadSnake();
        GameService game = new GameService(board, dice, players);
        game.manualStart();
    }

    private int askDiceCount() {
        int diceCount = nextInt("How many dice you want? Choose between 1 to 3");
        while (diceCount < 1 || diceCount > 3)
            diceCount = nextInt("How many dice you want? Choose between 1 to 3");
        return diceCount;
    }

    private int askBoardSize() {
        int boardSize = nextInt("Board size you want? Choose between 50 to 100");
        while (boardSize < 50 || boardSize > 100)
            boardSize = nextInt("Board size you want? Choose between 50 to 100");
        return boardSize;
    }

    private void playedBySystem() {
        List<Player> players = askPlayers(false);
        int diceCount = askDiceCount();
        int boardSize = askBoardSize();
        Dice dice = new Dice(diceCount);
        Board board = new Board(boardSize);
        board.loadLadder();
        board.loadSnake();
        GameService game = new GameService(board, dice, players);
        game.autoStart();
    }

    private List<Player> askPlayers(boolean includeMachine) {
        int count = nextInt("Enter number of players:");
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String name = nextLine("Enter player name: ");
            players.add(new Player(name));
        }

        if (includeMachine)
            players.add(new Player(GameService.MACHINE));
        return players;
    }

    private static void printMenu() {
        System.out.println("1. Played By System");
        System.out.println("2. Play With Machine");
        System.out.println("3. Play With Friends");
        System.out.println("0. Exit");
    }

    private static String nextLine(String prompt) {
        System.out.println(prompt);
        return SCANNER.next();
    }

    private static int nextInt(String prompt) {
        System.out.println(prompt);
        while (!SCANNER.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            SCANNER.next();
        }
        return SCANNER.nextInt();
    }
}
