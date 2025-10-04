package com.deeparishi.javaapp.lld.snakeladder.model;

public record Ladder(int top, int bottom) {

    public Ladder {
        if (top <= bottom)
            throw new IllegalArgumentException("On Ladder, Start pos of header should be greater than end pos");
    }
}