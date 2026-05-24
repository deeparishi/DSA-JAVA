package com.deeparishi.javaapp.lld.tictactoe;

import java.util.*;

public class TicTacToeGame {


    private final Deque<Player> players;
    private final Board board;

    public TicTacToeGame(List<Player> players) {
        if (players != null && !players.isEmpty()) {
            this.players = new ArrayDeque<>();
            this.players.addAll(players);
        } else {
            throw new RuntimeException("Players must to start the match!");
        }
        this.board = new Board(3, 3);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Player player = players.poll();
            System.out.println(player.getName() + ", Please Enter X-Axis : ");
            int x = scanner.nextInt();
            System.out.println(player.getName() + ", Please Enter Y-Axis : ");
            int y = scanner.nextInt();

            Map<String, Object> result = board.play(x, y, player.getSymbol());
            if (result.get("status").toString().equalsIgnoreCase("false")) {
                System.out.println(player.getName() + result.get("message"));
                players.addFirst(player);
            } else if (result.get("message").toString().contains("Congratulations")) {
                System.out.println(player.getName() + result.get("message"));
                break;
            } else {
                players.addLast(player);
            }
        }
    }
}