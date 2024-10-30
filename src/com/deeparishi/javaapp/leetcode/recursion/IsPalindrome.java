package com.deeparishi.javaapp.leetcode.recursion;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam"));
    }
    static   boolean isPalindrome(String s) {

       String ss = helperToValidate(s);
       return ss.equalsIgnoreCase(s);
    }

    static  String helperToValidate(String s) {
        if(s == null || s.length() <= 1) return s;

        return s.charAt(s.length() - 1) + helperToValidate(s.substring(0, s.length()-1));
    }


}
