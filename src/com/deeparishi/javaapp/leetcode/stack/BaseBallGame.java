package com.deeparishi.javaapp.leetcode.stack;

//https://leetcode.com/problems/baseball-game

import java.util.Stack;

public class BaseBallGame {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }

    public static int  calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for(String operation : operations){

            switch (operation){
                case "C":
                    stack.pop();
                    break;
                case "D":
                    Integer sum = stack.peek();
                    sum *= 2;
                    stack.push(sum);
                    break;
                case "+":
                    Integer last = stack.peek();
                    Integer previousLast = stack.get(stack.size()-2);
                    stack.push(last + previousLast);
                    break;
                default:
                    stack.push(Integer.parseInt(operation));
            }
        }

        int sum = 0;
        for (Integer i : stack)
            sum += i;

        return sum;



    }
}
