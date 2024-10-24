package com.deeparishi.javaapp.leetcode.stack;

// https://leetcode.com/problems/decoded-string-at-index/description/?envType=problem-list-v2&envId=stack
public class DecodedString {

    public static void main(String[] args) {
        System.out.println(decode("a23", 6));
    }

    static String decode(String s, int k) {

        long len = 0;

        for (char c : s.toCharArray())
            if( Character.isDigit(c))
                len *=  (c - '0');
            else
                len++;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= len;

            if (k == 0 || Character.isLetter(c) && k == len)
                return Character.toString(c);

            if (Character.isDigit(c))
                len /= (c - '0');
            else
                len--;
        }

            return null;
    }
}