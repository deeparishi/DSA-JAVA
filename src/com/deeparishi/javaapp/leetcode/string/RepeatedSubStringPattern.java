package com.deeparishi.javaapp.leetcode.string;

// https://leetcode.com/problems/repeated-substring-pattern/

import java.util.List;
import java.util.Map;

public class RepeatedSubStringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubString("abab"));
        System.out.println(repeatedSubString("aba"));
        System.out.println(repeatedSubString("abcabcabcabc"));
    }

    public static boolean repeatedSubString(String s) {
        String doubled = s.concat(s);
        String sub = doubled.substring(1, doubled.length() - 1);
        return sub.contains(s);
    }
}
