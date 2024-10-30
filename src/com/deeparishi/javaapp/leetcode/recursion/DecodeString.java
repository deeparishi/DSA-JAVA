package com.deeparishi.javaapp.leetcode.recursion;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {

        System.out.println(decodeString("3[a]2[bc]")); //aaabcbc
        System.out.println(decodeString("3[a2[c]]")); //accaccacc
        System.out.println(decodeString("2[abc]3[cd]ef")); //abcabccdcdcdef

    }

    static String decodeString(String s) {

        Stack<Integer> stack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder currentNum = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) currentNum.append(c);
            else if (c == '[') {
                stack.push(Integer.parseInt(currentNum.toString()));
                strStack.push(res.toString());
                res.setLength(0);
                currentNum.setLength(0);
            } else if (c == ']') {
                int repeatTimes = stack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                temp.append(String.valueOf(res).repeat(Math.max(0, repeatTimes)));
                res = temp;
            } else res.append(c);
        }

        return res.toString();
    }


}
