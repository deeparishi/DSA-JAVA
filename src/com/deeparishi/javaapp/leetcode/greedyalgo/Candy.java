package com.deeparishi.javaapp.leetcode.greedyalgo;

// https://leetcode.com/problems/candy/

public class Candy {

    public static void main(String[] args) {

        int[] r1 = {1, 0, 2}; // 5
        int[] r2 = {1, 2, 2}; // 4
        int[] r3 = {5, 2, 4, 7}; // 8

        System.out.println(candyV3(r1));
        System.out.println(candyV3(r2));
        System.out.println(candyV3(r3));

//        int[] r4 = {1, 2, 2, 3, 4, 3, 2, 1, 2, 2, 3, 4, 5, 1, 0, 0, 2, 3, 2, 1};
        int[] r4 = {0, 2, 4, 7, 6, 5, 4, 3, 2, 1, 1, 1, 2, 3, 4, 2, 1, 1, 1};
        System.out.println(candyV3(r4));
        System.out.println(candyV2(new int[]{1, 2, 2}));
    }

    /** Slope Based Approach
     <a href="https://youtu.be/IIqVFvKE6RY?list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea&t=1466">Reference vid</a>
     TC O(N) SC O(1) */
    public static int candyV3(int[] ratings) {

        int i = 1;
        int totalCandies = 1;
        int n = ratings.length;

        while (i < n) {

            // if it is a flat surface
            if (ratings[i] == ratings[i - 1]) {
                totalCandies += 1;
                i++;
                continue;
            }

            int peak = 1;

            // If the slope is increased
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                totalCandies += peak;
                i++;
            }

            int down = 1;

            // If the slope is decreased
            while (i < n && ratings[i] < ratings[i - 1]) {
                totalCandies += down;
                down++;
                i++;
            }

            if (down > peak)
                totalCandies += down - peak;
        }

        return totalCandies;
    }

    // TC O(2N) SC O(N)
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

    // TC O(3N) SC O(2N)
    public static int candyV1(int[] ratings) {

        int n = ratings.length;
        int[] left = new int[n];  // Left side comparison
        int[] right = new int[n]; // Right side comparison

        left[0] = 1; // first one be always the least one candy
        right[n - 1] = 1; // last one be always the least one candy

        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i]= 1;
        }

        for(int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }

        int totalCandies = 0;

        for(int i = 0; i < n; i++)
            totalCandies += Math.max(left[i], right[i]);

        return totalCandies;
    }
}