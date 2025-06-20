package com.deeparishi.javaapp.leetcode.dp;

// https://leetcode.com/problems/climbing-stairs/
// https://www.youtube.com/watch?v=mLfjzJsN8us&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
//        System.out.println(climbStairsV3(2));
        System.out.println(climbStairsV4(5));
//        System.out.println(climbStairsV3(3));
    }

    // Basic Recursion
    public static int climbStairs(int n) {

        if (n == 0 || n == 1) return 1;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // Using Memoization
    public static int climbStairsV2(int n) {
        return climbStairsV2(n, new HashMap<>());
    }

    public static int climbStairsV2(int n, Map<Integer, Integer> map) {

        if (n == 0 || n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);

        int ans = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, ans);
        return ans;
    }

    // using tabulation
    public static int climbStairsV3(int n) {

        int former = 1; // prev of behind e.g  1,2,3 former = 1; behind = 2; curr = 3
        int behind = 1; // behind of curr
        int curr = 0; // curr

        for (int i = 2; i <= n; i++) {
            curr = former + behind;
            former = behind;
            behind = curr;
        }

        return curr;
    }

    // using tabulation
    public static int climbStairsV4(int n) {

        int former = 1;
        int behind = 1;

        for (int i = 2; i <= n; i++) {
            int curr = former + behind;
            former = behind;
            behind = curr;
        }

        return behind;
    }
}