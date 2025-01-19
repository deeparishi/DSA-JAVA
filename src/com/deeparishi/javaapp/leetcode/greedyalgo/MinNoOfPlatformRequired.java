package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.Arrays;

public class MinNoOfPlatformRequired {

    public static void main(String[] args) {
        int[] arrival =     {900, 945, 955, 1100, 1500, 1800};
        int[] departure = {920, 1200, 1130, 1150, 1900, 2000};

        System.out.println(noOfPlatformRequired(arrival, departure));
    }

    private static int noOfPlatformRequired(int[] arrival, int[] departure) {

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0, j = 0;
        int platformCount = 0;
        int platformReq = Integer.MIN_VALUE;

        while (i < arrival.length && j < departure.length) {
            // If train is arriving increase the platform count, move pointer
            if (arrival[i] <= departure[j]) {
                platformCount++;
                i++;
            } else {
                // If train leaving decrease the platform count and move pointer
                platformCount--;
                j++;
            }
            platformReq = Math.max(platformCount, platformReq);
        }

        return platformReq;
    }

    public static int noOfPlatformRequiredBruteForce(int[] arrival, int[] dept) {

        int maxPlatform = Integer.MIN_VALUE;

        for (int i = 0; i < arrival.length; i++) {
            int currentPlatform = 1;
            for (int j = 0; j < dept.length; j++) {
                // Compare one arrival with each dept val and compare each arrival with one dept val
                if (i != j && arrival[i] < dept[j] && arrival[j] < dept[i]) {
                    currentPlatform++;
                }
            }
            maxPlatform = Math.max(maxPlatform, currentPlatform);
        }
        return maxPlatform;
    }
}
