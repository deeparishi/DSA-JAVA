package com.deeparishi.javaapp.leetcode.math;

public class Reverse {

    //https://leetcode.com/problems/reverse-integer/

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
    static int reverse(int x) {

        long res = 0;
        int a = x;
        while(a != 0){
            int unit = a % 10;
            res = (res * 10) + unit;
            a /= 10;
        }

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;

        return (int) res;
    }
}
