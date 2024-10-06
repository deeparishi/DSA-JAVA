package com.deeparishi.javaapp.leetcode;

//https://leetcode.com/problems/string-to-integer-atoi/

public class StingToInteger {

    public static void main(String[] args) {
        int a = myAtoi("   -42");
        System.out.println(a);
    }

    static int myAtoi(String s) {

        String element = s.trim();
        StringBuilder a = new StringBuilder();
        char[] arr = element.toCharArray();
        if (arr[0] == '-' || arr[0] == '+') {
            a.append(arr[0]);
        }
        for (char c : arr) {
            if (Character.isDigit(c)) {
                a.append(c);
            }
        }
        return Integer.parseInt(a.toString());
    }
}
