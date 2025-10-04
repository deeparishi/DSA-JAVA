package com.deeparishi.javaapp.lld.snakeladder.model;

public class Player {

    private final String name;
    private int pos;

    public Player(String name) {
        this.name = name;
        this.pos = 0;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

}
