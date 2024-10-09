package com.deeparishi.javaapp.old.leetcode;

import java.util.Stack;

//https://leetcode.com/problems/clear-digits
public class ClearDigits {

    public static void main(String[] args) {

    }

    public static String clearDigits(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if(Character.isDigit(c)){
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (Character c : stack){
            builder.append(c);
        }

        return builder.toString();

    }


}
