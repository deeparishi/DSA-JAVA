package com.deeparishi.javaapp.leetcode.string;

//https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].isEmpty()) {
                builder.append(split[i]).append(" ");
            }
        }

        return builder.toString().trim();
    }
}