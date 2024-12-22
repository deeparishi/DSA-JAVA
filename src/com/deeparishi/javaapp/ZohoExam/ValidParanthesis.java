package com.deeparishi.javaapp.ZohoExam;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> result = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                result.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (result.empty()) {
                    return false;
                }

                char openbrac = result.pop();
                if (c == '}' && openbrac != '{' ||
                        c == ']' && openbrac != '[' ||
                        c == ')' && openbrac != '(') {
                    return false;
                }
            }

        }
        return result.empty();
    }


}
