package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone

public class MinNoOfMoveToSeat {

    public static void main(String[] args) {

        System.out.println(minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4})); //4
        System.out.println(minMovesToSeat(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6})); // 7
        System.out.println(minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6})); // 4

    }

    public static int minMovesToSeat(int[] seats, int[] students) {

        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;

        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(students[i] - seats[i]);
        }

        return moves;
    }
}
