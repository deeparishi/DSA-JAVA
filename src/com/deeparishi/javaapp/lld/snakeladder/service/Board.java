package com.deeparishi.javaapp.lld.snakeladder.service;

import com.deeparishi.javaapp.lld.snakeladder.model.Ladder;
import com.deeparishi.javaapp.lld.snakeladder.model.Snake;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Board {

    private final int size;
    private Map<Integer, Snake> snakes;
    private Map<Integer, Ladder> ladder;
    private final Set<Integer> occupiedBox = new HashSet<>();
    private final int SNAKE_COUNT;
    private final int LADDER_COUNT;

    public Board(int size) {
        this.size = size;
        this.SNAKE_COUNT = 5;
        this.LADDER_COUNT = 6;
    }

    public Board(int size, int snakeCount, int ladderCount) {
        this.size = size;
        this.SNAKE_COUNT = snakeCount;
        this.LADDER_COUNT = ladderCount;
    }

    public int getNewPosition(int currPos) {
        if (snakes.containsKey(currPos))
            return snakes.get(currPos).tail();
        if (ladder.containsKey(currPos))
            return ladder.get(currPos).top();
        return currPos;
    }

    public int getSize() {
        return size;
    }

    public void loadSnake() {
        Random random = new Random();
        List<Snake> snakes = new ArrayList<>();

        while (snakes.size() < SNAKE_COUNT) {
            int head = random.nextInt(this.size - 1) + 2;
            int tail = random.nextInt(this.size - 1) + 1;
            if (tail < head && !occupiedBox.contains(head) && !occupiedBox.contains(tail)) {
                snakes.add(new Snake(head, tail));
                occupiedBox.add(head);
                occupiedBox.add(tail);
            }
        }

        System.out.println();
        System.out.println("FYI Snake Design");
        snakes.forEach(s -> System.out.printf("Head : %s ---> Tail : %s%n", s.head(), s.tail()));
        System.out.println();
        this.snakes = snakes.stream()
                .collect(Collectors.toMap(Snake::head, Function.identity()));
    }

    public void loadLadder() {
        Random random = new Random();
        List<Ladder> ladders = new ArrayList<>();

        System.out.println("FYI Ladder Design");
        while (ladders.size() < LADDER_COUNT) {
            int top = random.nextInt(this.size - 1) + 2;
            int bottom = random.nextInt(this.size - 1) + 1;
            if (top > bottom && !occupiedBox.contains(top) && !occupiedBox.contains(bottom)) {
                ladders.add(new Ladder(top, bottom));
                occupiedBox.add(top);
                occupiedBox.add(bottom);
            }
        }
        ladders.forEach(s -> System.out.printf("Bottom : %s ---> Top : %s%n", s.bottom(), s.top()));
        System.out.println();
        this.ladder = ladders.stream()
                .collect(Collectors.toMap(Ladder::bottom, Function.identity()));
    }

}
