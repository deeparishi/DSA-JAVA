package com.deeparishi.javaapp.leetcode.math;

public class WaterBottles {

    // https://leetcode.com/problems/water-bottles/description/

    public static void main(String[] args) {

        System.out.println(numWaterBottlesV1(15, 4));
    }

    public static int numWaterBottlesV1(int numBottles, int numExchange) {

        int total = numBottles;

        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            int left = numBottles % numExchange;
            total += newBottles;
            numBottles = newBottles + left;
        }

        return total;
    }

    public static int numWaterBottlesV2(int fullBottles, int exchange) {
        return fullBottles + tradeBottle(fullBottles, exchange);
    }

    private static int tradeBottle(int emptyBottles, int exchange) {
        if (emptyBottles < exchange)
            return 0;

        int newFull = emptyBottles / exchange;
        int remainingEmptyBottle = emptyBottles % exchange;

        return newFull + tradeBottle(newFull + remainingEmptyBottle, exchange);
    }
}