package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/6171990#learning-tools

class BalancedParenthesis {

     public static void main(String[] args) {
         System.out.println(isBalanced("()[{}()]"));
     }

     public static boolean isBalanced(String expression) {
         Stack<Character> stack = new Stack<>();


         for(char c : expression.toCharArray()){
             if(c == '{' || c == '[' || c == '(') {
                 stack.push(c);
                 continue;
             }

             else if (c == ')' || c == ']' || c == '}') {
                 if (stack.isEmpty()) {
                     return false;
                 }
                 char top = stack.pop();
                 if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                     return false;
                 }
             }
         }

         return stack.isEmpty();

     }
}
