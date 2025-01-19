package com.deeparishi.javaapp.leetcode.greedyalgo;

// https://leetcode.com/problems/candy/

import java.util.Arrays;

public class Candy {

    public static void main(String[] args) {

        int[] r1 = {1, 0, 2}; // 5
        int[] r2 = {1, 2, 2}; // 4
        int[] r3 = {5, 2, 4, 7}; // 8

        System.out.println(candyV3(r1));
        System.out.println(candyV3(r2));
        System.out.println(candyV3(r3));
    }

    // Slope Based Approach
    // https://youtu.be/IIqVFvKE6RY?list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea&t=1466
    public static int candyV3(int[] ratings) {

        int n = ratings.length;
        int candy = n, i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            //For increasing slope
            int peak = 0;
            while (ratings[i] > ratings[i - 1]) {
                peak++;
                candy += peak;
                i++;
                if (i == n) return candy;
            }

            //For decreasing slope
            int valley = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                valley++;
                candy += valley;
                i++;
            }
            candy -= Math.min(peak, valley); //Keep only the higher peak
        }
        return candy;
    }


    public static int candyV2(int[] ratings) {

        int n = ratings.length;
        int[] left = new int[n];

        left[0] = 1;

        // Fill the left array (left-to-right pass)
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        int curr = 1;
        int sum = left[n - 1];

        // Right-to-left pass and calculate the total sum
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                curr++;
            else
                curr = 1;
            sum += Math.max(left[i], curr);
        }

        return sum;
    }

    public static int candyV1(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}