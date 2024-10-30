package com.deeparishi.javaapp.leetcode.recursion;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse("Java"));
    }

    static String reverse(String str) {

        if(str == null || str.length() <= 1) return str;

        return str.charAt(str.length() - 1)
                + reverse(str.substring(0, str.length() - 1));
    }
}
