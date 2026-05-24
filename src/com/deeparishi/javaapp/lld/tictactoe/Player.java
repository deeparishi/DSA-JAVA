package com.deeparishi.javaapp.lld.tictactoe;


public class Player {

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    private String name;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
