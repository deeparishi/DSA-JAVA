package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/

public class OnlineStockSpan {

    private Stack<int[]> stack;


    public OnlineStockSpan() {
        this.stack = new Stack<>();
    }


    public int next(int price) {

        int data = 1;

        while (!stack.isEmpty() && price >= stack.peek()[0]){
            data += stack.pop()[1];
        }

        stack.push(new int[]{price, data});

        return data;
    }
}

class MainClas{

    public static void main(String[] args) {

        OnlineStockSpan span = new OnlineStockSpan();

        System.out.println(span.next(100));
        System.out.println(span.next(80));
        System.out.println(span.next(60));
        System.out.println(span.next(70));
        System.out.println(span.next(60));
        System.out.println(span.next(75));
        System.out.println(span.next(85));

    }
}