package com.deeparishi.javaapp.leetcode.string;

public class ReverseArrayString {

    public static void main(String[] args) {
        char [] arr = new char[]{'N','A', 'T', 'A', 'R', 'A', 'J', 'A'};
        reverseString(arr);

        for (char c : arr)
            System.out.println(c);
    }

    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length-1;

        while (left!=right && left-1!=right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
