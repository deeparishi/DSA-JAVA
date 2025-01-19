package com.deeparishi.javaapp.dsaconcepts.greedyalgo.udemy.coinchange;

import java.util.Arrays;

public class CoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5, 10, 20, 50, 100, 1000};
        coinChange(coins, 2035);
        System.out.println();
        coinChange(coins, 70);
    }

    static void coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int idx = coins.length - 1;

        do {
            int coinVal = coins[idx];
            idx--;
            int maxAmount = (amount / coinVal) * coinVal;

            if (maxAmount > 0) {
                System.out.println("Coin Value : " + coinVal + " taken count : " + amount / coinVal);
                amount = amount - maxAmount;
            }
        } while (amount != 0);
    }
}
