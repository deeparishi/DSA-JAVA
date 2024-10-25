package com.deeparishi.javaapp.leetcode.stack;

//https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/?envType=problem-list-v2&envId=stack&difficulty=EASY

import java.util.Stack;

public class MinimumLength {

    public static void main(String[] args) {
        System.out.println(minLengthOptimized("ABFCACDB"));
        System.out.println(minLengthOptimized("ACBBD"));
    }

    static int minLength(String s) {

        while (s.contains("AB") || s.contains("CD")){
            if(s.contains("AB")) s = s.replace("AB", "");
            else if(s.contains("CD")) s = s.replace("CD", "");
        }

        return s.length();

    }

    static int minLengthOptimized(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if(stack.isEmpty())
                stack.push(curr);

            else if(curr == 'B' && stack.peek() == 'A')
                stack.pop();

            else if(curr == 'D' && stack.peek() == 'C')
                stack.pop();
            else
                stack.push(curr);
        }

        return stack.size();

    }
}
