package com.deeparishi.javaapp.leetcode.greedyalgo;

// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid

import java.util.Stack;

public class CheckParenthesisStringValid {

    public static void main(String[] args) {
        System.out.println(canBeValid("))()))", "010100"));
        System.out.println(canBeValid(")", "0"));
    }


    public static boolean canBeValid(String s, String locked) {

        if (s.length() % 2 != 0) return false;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') open++;
            else open--;
            if (open < 0) return false;
        }

        open = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')')
                open++;
            else
                open--;
            if (open < 0)
                return false;
        }

        return true;

    }

    public boolean canBeValidBruteForce(String s, String locked) {
        if (s.isEmpty() || s.length() % 2 != 0 || s.length() != locked.length()) {
            return false;
        }

        Stack<Integer> openStack = new Stack<>(); // Stack for open '(' indices
        Stack<Integer> flexStack = new Stack<>(); // Stack for flexible '0' indices

        // First pass: process the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char lock = locked.charAt(i);

            if (lock == '1') {
                if (ch == '(') {
                    openStack.push(i);
                } else {
                    if (!openStack.isEmpty()) {
                        openStack.pop(); // Match with a locked '('
                    } else if (!flexStack.isEmpty()) {
                        flexStack.pop(); // Use a flexible '(' to match
                    } else {
                        return false; // No match available
                    }
                }
            } else {
                flexStack.push(i);
            }
        }

        while (!openStack.isEmpty() && !flexStack.isEmpty()) {
            if (openStack.peek() > flexStack.peek()) {
                return false;
            }
            openStack.pop();
            flexStack.pop();
        }

        return openStack.isEmpty() && flexStack.size() % 2 == 0;
    }

}
