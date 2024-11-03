package com.deeparishi.javaapp.leetcode.string;

//https://leetcode.com/problems/rotate-string/description/?envType=daily-question&envId=2024-11-03
public class RotateString {

    public static void main(String[] args) {

        System.out.println(rotateString("abcde","cdeab"));   // True
        System.out.println(rotateString( "abcde","abced"));  // False
    }

    static boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) return false;

        String conc = s + s;
        return conc.contains(goal);
    }
}