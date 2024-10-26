package com.deeparishi.javaapp.leetcode.string;

public class StringToBinary {

    public static void main(String[] args) {

        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {

        int first = Integer.parseInt(a);
        int second = Integer.parseInt(b);

        return Integer.toBinaryString(first) + Integer.toBinaryString(second);
    }
}
