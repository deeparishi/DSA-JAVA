package com.deeparishi.javaapp.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class NumberFactor {

    public static void main(String[] args) {

        System.out.println(commonFactors(12, 6));
        System.out.println(commonFactors(25, 30));
    }

    public static int commonFactors(int a, int b) {

        int gcd = findGCD(a, b);
        int count = 0;
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= gcd; i++) {
            if(gcd % i == 0) {
                count++;
                factors.add(i);
            }
        }

        System.out.println(factors);
        return count;
    }

    public List<Integer> commonFactorsV2(int a, int b) {
        int gcd = findGCD(a, b);
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= gcd; i++) {
            if (gcd % i == 0)
                factors.add(i);
        }

        return factors;
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
