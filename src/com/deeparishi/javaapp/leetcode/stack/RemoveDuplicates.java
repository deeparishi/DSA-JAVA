package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/?envType=problem-list-v2&envId=stack&difficulty=EASY

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicatesNew("abbaca"));
        System.out.println(removeDuplicatesNew("azxxzy"));
    }

    static String removeDuplicates(String s) {

        StringBuilder res = new StringBuilder();
        Stack<Character> ch = new Stack<>();

        for(char c : s.toCharArray()){
            if(ch.isEmpty())
                ch.push(c);
            else if(c == ch.peek()){
                ch.pop();
            }else{
                ch.push(c);
            }
        }

        for (Character c : ch)
            res.append(c);

        return res.toString();

    }

    static String removeDuplicatesNew(String s) {

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c)
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(c);
        }

        return sb.toString();
    }

}
