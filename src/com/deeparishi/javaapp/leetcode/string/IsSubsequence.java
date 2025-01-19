package com.deeparishi.javaapp.leetcode.string;

// https://leetcode.com/problems/is-subsequence/

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty()) return false;
        int sIdx = 0;
        int tIdx = 0;
        int len = 0;

        while (len < t.length()) {

            char sChar = s.charAt(sIdx);
            char tChar = t.charAt(tIdx);

            if(Character.toLowerCase(sChar) == Character.toLowerCase(tChar))
                sIdx++;

            tIdx++;
            len++;

        }
        return s.length() - 1  == sIdx;
    }
}
