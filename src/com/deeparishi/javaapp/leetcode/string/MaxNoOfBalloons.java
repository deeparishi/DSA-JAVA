package com.deeparishi.javaapp.leetcode.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-number-of-balloons/

public class MaxNoOfBalloons {

    public static void main(String[] args) {

        System.out.println(maxNumberOfBalloons("balon"));
    }

    public static int maxNumberOfBalloons(String text) {

        Map<Character, Integer> textMap = new HashMap<>();

        for (char ch : text.toCharArray())
            textMap.put(ch, textMap.getOrDefault(ch, 0) + 1);

        int b = textMap.getOrDefault('b', 0);
        int a = textMap.getOrDefault('a', 0);
        int l = textMap.getOrDefault('l', 0) / 2;
        int o = textMap.getOrDefault('o', 0) / 2;
        int n = textMap.getOrDefault('n', 0);

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));

    }

    public static int maxNumberOfBalloonsV2(String text) {

        int[] l = new int[26];
        for (char i : text.toCharArray())
            ++l[i - 'a'];

        int res;
        res = Math.min(l['b' - 'a'], l[0]);
        res = Math.min(res, l['l' - 'a'] / 2);
        res = Math.min(res, l['o' - 'a'] / 2);
        res = Math.min(res, l['n' - 'a']);

        return res;
    }
}
