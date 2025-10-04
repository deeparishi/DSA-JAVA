package com.deeparishi.javaapp.lld.snakeladder.model;


public class Dice {

    private final int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int roll() {
        return ((int) (Math.random() * (6 * numberOfDice - numberOfDice))) + 1;
    }


}
