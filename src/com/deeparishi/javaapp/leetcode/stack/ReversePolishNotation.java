package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    static int evalRPN(String[] tokens) {

        Stack<Integer> result = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = result.pop();
                int a = result.pop();
                int res = applyOperation(a, b, token);
                result.push(res);
            } else {
                result.push(Integer.parseInt(token));
            }
        }

        return result.pop();
    }

    private static int applyOperation(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> -1;
        };
    }

    private static boolean isOperator(String s) {
        return s.equals("+") ||
                s.equals("-") ||
                s.equals("*") ||
                s.equals("/");
    }
}
