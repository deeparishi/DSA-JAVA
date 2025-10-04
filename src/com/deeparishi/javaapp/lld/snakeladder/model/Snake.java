package com.deeparishi.javaapp.lld.snakeladder.model;

public record Snake(int head, int tail) {

    public Snake {
        if (tail >= head)
            throw new IllegalArgumentException("On snake, Tail pos should be lesser than head");
    }
}