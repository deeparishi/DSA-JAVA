package com.deeparishi.javaapp.leetcode.string;

import java.util.Arrays;
import java.util.Stack;
import java.util.Stack;

public class RemoveUnbalancedParentheses {

    public static void main(String[] args) {
        String input1 = "((abc)((de))";
        String input2 = "(((ab)";

        System.out.println(removeUnbalancedParentheses(input1)); // Output: ((abc)(de))
        System.out.println(removeUnbalancedParentheses(input2)); // Output: (ab)


    }

    public static String removeUnbalancedParentheses(String expression) {
        Stack<Integer> stack = new Stack<>();
        boolean[] toRemove = new boolean[expression.length()];

        // First pass: identify unbalanced parentheses
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stack.push(i); // Store the index of '('
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    // No matching '(', mark this ')' for removal
                    toRemove[i] = true;
                } else {
                    stack.pop(); // Found a matching '('
                }
            }
        }

        // Mark remaining '(' in the stack for removal
        while (!stack.isEmpty()) {
            toRemove[stack.pop()] = true;
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (!toRemove[i]) {
                result.append(expression.charAt(i)); // Only add valid characters
            }
        }

        return result.toString();
    }


}
