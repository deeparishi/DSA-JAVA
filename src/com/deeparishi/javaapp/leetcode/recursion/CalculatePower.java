package com.deeparishi.javaapp.leetcode.recursion;

public class CalculatePower {

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }

    static int pow(int base, int exp){
        if(exp == 0) return 1;
        return base * pow(2, exp - 1);
    }
}
