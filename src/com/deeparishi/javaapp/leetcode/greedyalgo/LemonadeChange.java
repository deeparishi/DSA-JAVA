package com.deeparishi.javaapp.leetcode.greedyalgo;

// https://leetcode.com/problems/lemonade-change

public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 10, 10, 5, 20, 5, 10, 5, 5};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {

        int fives = 0;
        int tens = 0;
        int twenties = 0;

        for (int bill : bills) {
            if (bill == 5) fives += 1;
            else if (bill == 10) {
                tens += 1;
                if (fives >= 1) fives -= 1;
                else return false;
            } else {
                twenties += 1;
                if (tens >= 1 && fives >= 1) {
                    fives -= 1;
                    tens -= 1;
                } else if (fives >= 3) fives -= 3;
                else
                    return false;

            }
        }

        return true;
    }
}
