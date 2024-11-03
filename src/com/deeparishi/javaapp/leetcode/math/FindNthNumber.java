package com.deeparishi.javaapp.leetcode.math;

public class FindNthNumber {

    public static void main(String[] args) {
        String result = findNthNumber(12, 5, 14);
        System.out.println(result);
    }

    public static String findNthNumber(int n, int fn, int sn) {

        StringBuilder number = new StringBuilder();

        while (n > 0) {
            int bit = (n - 1) % 2;
            if (bit == 0) number.append(fn);
            else number.append(sn);
            n = (n - 1) / 2;
        }

        return number.reverse().toString();
    }
}
