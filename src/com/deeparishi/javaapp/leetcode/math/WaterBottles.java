package com.deeparishi.javaapp.leetcode.math;

public class WaterBottles {

    // https://leetcode.com/problems/water-bottles/description/

    public static void main(String[] args) {

        System.out.println(numWaterBottles(15, 4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {

        int total = numBottles;

        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            int left = numBottles % numExchange;
            total += newBottles;
            numBottles = newBottles + left;
        }

        return total;
    }
}
