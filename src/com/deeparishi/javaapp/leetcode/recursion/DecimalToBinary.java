package com.deeparishi.javaapp.leetcode.recursion;

public class DecimalToBinary {

    public static void main(String[] args) {

        System.out.println(decimalToBinary(10));
    }

    static int decimalToBinary(int v){

        if(v == 0){
            return 0;
        }

        return v % 2 + 10 * decimalToBinary(v / 2);
    }
}
