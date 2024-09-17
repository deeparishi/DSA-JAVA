package com.deeparishi.javaapp.leetcode;

//https://leetcode.com/problems/find-the-difference

public class FindTheDifference {

    public static void main(String[] args) {

        System.out.println(findTheDifference("abcd", "abcde"));

    }

    public static char findTheDifference(String s, String t) {

        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;

        }

        // XOR all characters in t
        for (char c : t.toCharArray()) {
            result ^= c;
        }

        // The result will be the extra character in t
        return result;
    }
}
