package com.deeparishi.javaapp.leetcode.math;

public class FindSquareRoot {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(6));
        System.out.println(findSquareRoot(7));
    }

    private static double findSquareRoot(int v) {

        double t;
        double sqrtroot = (double) v / 2;
        do {
            t = sqrtroot;
            sqrtroot = (t + (v / t)) / 2;
        }
        while ((t - sqrtroot) != 0);
        return sqrtroot;
    }
}
