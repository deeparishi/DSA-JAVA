package com.deeparishi.javaapp.dsaconcepts.dp;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4
// 18-02-25

public class FrogJump {

    public static void main(String[] args) {

        int[] arr1 = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJumpV1(arr1, arr1.length - 1));
        System.out.println(frogJumpV2(arr1, arr1.length - 1));
        System.out.println(frogJumpV3(arr1, arr1.length));
        System.out.println(frogJumpV4(arr1, arr1.length));
    }

    // Normal Recursive Approach
    public static int frogJumpV1(int[] arr, int len) {

        if (len == 0) return 0;
        if (len < 0) return 0;

        int left = frogJumpV1(arr, len - 1) + Math.abs(arr[len] - arr[len - 1]);
        int right = Integer.MAX_VALUE;

        if (len > 1) right = frogJumpV1(arr, len - 2) + Math.abs(arr[len] - arr[len - 2]);
        return Math.min(left, right);
    }

    // Time Optimization
    public static int frogJumpV2(int[] arr, int len) {
        return frogJumpV2(arr, len, new HashMap<>());
    }

    // Memoization Approach
    public static int frogJumpV2(int[] arr, int len, Map<Integer, Integer> map) {

        if (len == 0) return 0;
        if (map.containsKey(len)) return map.get(len);

        int left = frogJumpV1(arr, len - 1) + Math.abs(arr[len] - arr[len - 1]);
        int right = 0;

        if (len > 1) right = frogJumpV1(arr, len - 2) + Math.abs(arr[len] - arr[len - 2]);
        int res = Math.min(left, right);
        map.put(len, res);
        return res;
    }

    // Tabulation Approach with Array
    public static int frogJumpV3(int[] arr, int len) {

        int[] dp = new int[len];
        dp[0] = 0;

        for (int i = 1; i < len; i++) {
            int firstStep = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int secondStep = Integer.MAX_VALUE;
            if (i > 1)
                secondStep = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            dp[i] = Math.min(firstStep, secondStep);
        }

        return dp[len - 1];
    }

    // Tabulation Approach without Array (space optimization)
    public static int frogJumpV4(int[] arr, int len) {

        if (len == 1) return 0;

        int former = 0;
        int behind = 0;
//        int behind = Math.abs(arr[1] - arr[0]);  //It also works

        for (int i = 2; i < len; i++) {
            int firstStep = behind + Math.abs(arr[i] - arr[i - 1]);
            int secondStep = former + Math.abs(arr[i] - arr[i - 2]);

            former = behind;
            behind = Math.min(firstStep, secondStep);
        }

        return behind;
    }
}
