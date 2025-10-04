package com.deeparishi.javaapp.leetcode.top150.array_string;

// https://leetcode.com/problems/gas-station/

public class GasStation {

    public static void main(String[] args) {
        System.out.println(
                canCompleteCircuitOptimal(new int[]{2, 3, 4, 1, 5}, new int[]{3, 4, 5, 1, 2})
        );

    }

    public static int canCompleteCircuitOptimal(int[] gas, int[] cost) {
        int total = 0, avail = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            avail += gas[i] - cost[i];
            if (avail < 0) {
                avail = 0;
                index = i + 1;
            }
        }
        if (total < 0) {
            return -1;
        }
        return index;
    }

    public static int canCompleteCircuitBruteForce(int[] gas, int[] cost) {

        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int remainingGas = 0;
            for (int j = 0; j < n; j++) {
                int idx = (i + j) % n;
                remainingGas += gas[idx] - cost[idx];
                if (remainingGas < 0) {
                    break;
                }
            }
            if (remainingGas >= 0)
                return i;

        }

        return -1;
    }
}
