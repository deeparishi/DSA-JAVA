package com.deeparishi.javaapp.leetcode.string;

// https://leetcode.com/problems/find-the-original-typed-string-i/

public class OriginalTypedString {

    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
        System.out.println(possibleStringCount("abcd"));
        System.out.println(possibleStringCount("aaaa"));
    }

    public static int possibleStringCount(String word) {
        int n = word.length();
        int total = 1;

        for (int i = 0; i < n;) {

            int j = i;

            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }

            int groupLength = j - i;

            if (groupLength > 1) {
                total += groupLength - 1;
            }

            i = j;
        }

        return total;
    }
}
