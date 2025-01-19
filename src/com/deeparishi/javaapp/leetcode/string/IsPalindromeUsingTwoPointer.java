package com.deeparishi.javaapp.leetcode.string;

// https://leetcode.com/problems/valid-palindrome/

public class IsPalindromeUsingTwoPointer {

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("aa"));

        isPalindrome("A man, a plan, a canal: Panama");
        isPalindrome("race a car");
    }

    public static boolean isPalindrome(String s) {

        if (s.trim().isEmpty()) return true;

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {

            char x = s.charAt(start);
            char y = s.charAt(end);

            if (!Character.isLetterOrDigit(x)) start++;
            else if (!Character.isLetterOrDigit(y)) end--;
            else {
                if (Character.toLowerCase(x) != Character.toLowerCase(y)) return false;
                start++;
                end--;
            }
        }

        return true;
    }


    public static boolean isPalindromeBrute(String s) {
        if (s.trim().isEmpty()) return true;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i);
            if ((v >= 97 && v <= 122) || (v >= 65 && v <= 90) || (v >= 48 && v <= 57))
                builder.append(s.charAt(i));
        }

        String org = builder.toString().toLowerCase();


        int start = 0;
        int mid = org.length() / 2;
        int end = org.length() - 1;

        while (start <= mid && end >= mid) {
            if (org.charAt(start) != org.charAt(end))
                return false;
            start++;
            end--;
        }

        return end <= start;
    }
}