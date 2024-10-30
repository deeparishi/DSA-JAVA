package com.deeparishi.javaapp.leetcode.recursion;

public class FirstUppercase {

    public static void main(String[] args) {

        System.out.println(first("appmillerS"));
    }

    static char first(String str) {

        if(str.length() == 1){
            return Character.toUpperCase(str.charAt(0));
        }

        return first(str.substring(1));
    }
}
