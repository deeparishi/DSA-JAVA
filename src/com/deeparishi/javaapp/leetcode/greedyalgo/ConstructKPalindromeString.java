package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeString {

    public static void main(String[] args) {

    }

    public static boolean canConstruct(String s, int k) {

        if (k > s.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int odd = 0;

        for (Integer val : map.values()) {
            if (val % 2 != 0) odd++;
        }

        return odd <= k;
    }

    public static boolean canConstructV2(String s, int k) {

        if (k > s.length()) return false;

        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        int odd = 0;

        for (int val : arr) {
            if (val % 2 != 0) odd++;
        }

        return odd <= k;
    }


}
