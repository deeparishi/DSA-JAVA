package com.deeparishi.javaapp.lld.snakeladder.service;

import com.deeparishi.javaapp.lld.snakeladder.model.Dice;
import com.deeparishi.javaapp.lld.snakeladder.model.Player;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GameService {

    private final Board board;
    private final Dice dice;
    private final Queue<Player> playersQueue;
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String MACHINE = "MACHINE";
    private final LocalDateTime startedAt;
    private Player winner;

    public GameService(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        this.playersQueue = new LinkedList<>(players);
        this.startedAt = LocalDateTime.now();
    }

    public void autoStart() {
        System.out.println("Starting automatic game...\n");
        while (true) {
            Player currPlayer = playersQueue.poll();
            waitInterval();

            System.out.printf("This is %s's turn. Current position: %d%n", currPlayer.getName(), currPlayer.getPos());

            int rolledVal = dice.roll();
            System.out.printf("Dice rolled: %d%n", rolledVal);

            if (movePlayer(currPlayer, rolledVal)) {
                winner = currPlayer;
                break;
            }

            playersQueue.offer(currPlayer);
            System.out.println();
        }
        calculateResult();
    }

    public void manualStart() {
        System.out.println("Starting manual game...\n");
        while (true) {
            Player currPlayer = playersQueue.poll();
            waitInterval();

            if (currPlayer != null && isMachine(currPlayer)) {
                simulateMachineRoll(currPlayer);
            } else if (currPlayer != null) {
                waitForUserRoll(currPlayer);
            }

            int rolledVal = dice.roll();
            System.out.printf("Dice rolled: %d%n", rolledVal);

            if (currPlayer != null && movePlayer(currPlayer, rolledVal)) {
                winner = currPlayer;
                break;
            }

            playersQueue.offer(currPlayer);
            System.out.println();
        }
        calculateResult();
    }

    private boolean movePlayer(Player player, int rolledVal) {
        int currPos = player.getPos();
        int newPos = currPos + rolledVal;

        if (newPos == board.getSize()) {
            player.setPos(newPos);
            System.out.printf("Congratulations %s, you won the match!%n", player.getName());
            return true;
        }

        if (newPos > board.getSize()) {
            System.out.printf("Alas %s, rolled %d which moves beyond the board size (%d). Staying at %d.%n",
                    player.getName(), rolledVal, board.getSize(), currPos);
            return false;
        }

        if (newPos == currPos) {
            System.out.printf("Oh no %s, rolled zero progress. Staying at %d.%n", player.getName(), currPos);
            return false;
        }

        int adjustedPos = board.getNewPosition(newPos);
        player.setPos(adjustedPos);

        if (adjustedPos > newPos)
            System.out.printf("Great! %s climbed a ladder from %d to %d.%n", player.getName(), newPos, adjustedPos);
        else if (adjustedPos < newPos)
            System.out.printf("Oops! %s got bitten by a snake from %d down to %d.%n", player.getName(), newPos, adjustedPos);
        else
            System.out.printf("%s moved to position %d.%n", player.getName(), newPos);

        return false;
    }

    private void waitForUserRoll(Player player) {
        System.out.printf("Press 'X' to roll the dice, %s:%n", player.getName());
        String input = SCANNER.next();
        while (!input.equalsIgnoreCase("X")) {
            System.out.printf("Invalid input. Please press 'X' to roll the dice, %s:%n", player.getName());
            input = SCANNER.next();
        }
    }

    private void simulateMachineRoll(Player player) {
        System.out.printf("It's %s's turn. Rolling dice automatically...\n", player.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while simulating machine roll.");
        }
        System.out.println("X");
    }

    private boolean isMachine(Player player) {
        return MACHINE.equalsIgnoreCase(player.getName());
    }

    private void waitInterval() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted during wait interval.");
        }
    }

    private void calculateResult() {
        System.out.println();
        System.out.println("--------------------RESULTS--------------------------------");
        System.out.printf("Started at: %s%n", startedAt);
        LocalDateTime endedAt = LocalDateTime.now();
        System.out.printf("Ended at: %s%n", endedAt);

        long diff = Duration.between(this.startedAt, endedAt).getSeconds();
        System.out.printf("Time taken in seconds: %d%n", diff);

        System.out.printf("Winner is: %s%n", winner.getName());

        AtomicInteger rank = new AtomicInteger(2);

        playersQueue.stream()
                .filter(p -> !p.equals(winner))
                .sorted((p1, p2) -> Integer.compare(p2.getPos(), p1.getPos()))
                .forEach(p -> System.out.printf("Runner-up %d: %s (Position: %d)%n",
                        rank.getAndIncrement(), p.getName(), p.getPos()));

        System.out.println();
    }

}