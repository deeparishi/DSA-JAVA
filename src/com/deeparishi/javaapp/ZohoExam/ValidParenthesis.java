package com.deeparishi.javaapp.ZohoExam;

import java.util.Stack;

public class ValidParenthesis {
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

                char open = result.pop();
                if (c == '}' && open != '{' ||
                        c == ']' && open != '[' ||
                        c == ')' && open != '(') {
                    return false;
                }
            }

        }
        return result.empty();
    }


}
