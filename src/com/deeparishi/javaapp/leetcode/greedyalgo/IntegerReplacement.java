package com.deeparishi.javaapp.leetcode.greedyalgo;

// https://leetcode.com/problems/integer-replacement

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

    public static void main(String[] args) {

        System.out.println(integerReplacementV2(8));
        System.out.println(integerReplacementV2(7));
        System.out.println(integerReplacementV2(2147483647));
    }

    // Optimal Solution
    public static int integerReplacementV2(int n) {
        return integerReplacementV2(n, 0, new HashMap<>());
    }

    private static int integerReplacementV2(long val, int count, Map<Long, Integer> map) {

        if (val <= 1) return count;
        if (map.containsKey(val)) return map.get(val) + count;
        int res;

        if (val % 2 == 0)
            res = integerReplacementV2(val / 2, count + 1, map);
        else {
            int x = integerReplacementV2(val + 1, count + 1, map);
            int y = integerReplacementV2(val - 1, count + 1, map);
            res = Math.min(x, y);
        }

        map.put(val, res - count);
        return res;
    }

    // Brute Force Approach
    public static int integerReplacementV1(int n) {
        return integerReplacementV1((long) n, 0);
    }

    private static int integerReplacementV1(long n, int count) {

        if (n <= 1) return count;
        if (n % 2 == 0) return integerReplacementV1(n / 2, count + 1);

        else {
            int a = integerReplacementV1(n + 1, count + 1);
            int b = integerReplacementV1(n - 1, count + 1);
            return Math.min(a, b);
        }
    }
}