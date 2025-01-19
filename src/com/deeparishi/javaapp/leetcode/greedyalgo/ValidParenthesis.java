package com.deeparishi.javaapp.leetcode.greedyalgo;

// https://leetcode.com/problems/valid-parenthesis-string/description/

public class ValidParenthesis {

    public static void main(String[] args) {

        System.out.println(checkValidStringV2("()"));
        System.out.println(checkValidStringV2("(*)"));
        System.out.println(checkValidStringV2("(*))"));
    }

    public static boolean checkValidStringV2(String s) {

        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                min += 1;
                max += 1;
            } else if (s.charAt(i) == ')') {
                min -= 1;
                max -= 1;
            } else {
                min -= 1;
                max += 1;
            }

            if (min < 0) min = 0;
            if (max < 0) return false;
        }

        return min == 0;
    }

    // Brute Force Approach
    public static boolean checkValidStringV1(String s) {
        return checkValidString(s, 0, 0);
    }

    private static boolean checkValidString(String s, int idx, int count) {

        if (count < 0) return false;
        if (idx == s.length()) return count == 0;

        if (s.charAt(idx) == '(')
            return checkValidString(s, idx + 1, count + 1);
        else if (s.charAt(idx) == ')')
            return checkValidString(s, idx + 1, count - 1);

        return checkValidString(s, idx + 1, count + 1) ||
                checkValidString(s, idx + 1, count - 1) ||
                checkValidString(s, idx + 1, count);
    }
}