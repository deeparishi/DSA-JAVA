package com.deeparishi.javaapp.dsaconcepts.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=tyB0ztf0DNY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=2
// Date - 17/2/25

public class FibonacciUsingMemoization {

    public static void main(String[] args) {

        System.out.println(fibonacciV1(5, new HashMap<>()));
        System.out.println(fibonacciV1(6, new HashMap<>()));

        System.out.println();

        int[] arr1 = new int[6];
        Arrays.fill(arr1, -1);

        int[] arr2 = new int[7];
        Arrays.fill(arr2, -1);

        System.out.println(fibonacciV2(5, arr1));
        System.out.println(fibonacciV2(6, arr2));

        System.out.println();

        System.out.println(fibonacciV3(5));
        System.out.println(fibonacciV3(6));

        System.out.println();

        System.out.println(fibonacciV4(5));
        System.out.println(fibonacciV4(6));
    }

    /*
         Using Memoization with Map
         TC - O(N)
         SC - O(N) recursion + O(N) map
     */
    public static int fibonacciV1(int val, Map<Integer, Integer> map) {

        if (val <= 1)
            return val;
        if (map.containsKey(val))
            return map.get(val);

        int res = fibonacciV1(val - 1, map) + fibonacciV1(val - 2, map);
        map.put(val, res);
        return res;
    }

    /*
             Using Memoization with Array
             TC - O(N)
             SC - O(N) recursion + O(N) array
         */
    public static int fibonacciV2(int val, int[] dp) {

        if (val <= 1)
            return val;
        if (dp[val] != -1) return dp[val];

        int res = fibonacciV2(val - 1, dp) + fibonacciV2(val - 2, dp);
        dp[val] = res;
        return res;
    }

    /*
             Using Tabulation with Array
             TC - O(N)
             SC - O(N) Array
    */
    public static int fibonacciV3(int val) {

        int[] arr = new int[val + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= val; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[val];
    }

    /*
             Using Tabulation without array
             TC - O(N)
             SC - O(1)
         */
    public static int fibonacciV4(int val) {

        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i <= val; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}