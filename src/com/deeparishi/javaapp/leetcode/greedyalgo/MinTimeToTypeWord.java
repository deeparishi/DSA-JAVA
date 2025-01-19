package com.deeparishi.javaapp.leetcode.greedyalgo;

// https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter

public class MinTimeToTypeWord {

    public static void main(String[] args) {
        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
        System.out.println(minTimeToType("zjpc"));
    }

    public static int minTimeToType(String word) {

        int steps = 0;
        char curr = 'a';

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int diff = Math.abs(ch - curr);
            steps += Math.min(diff, 26 - diff) + 1;
            curr = ch;
        }
        return steps;
    }
}
