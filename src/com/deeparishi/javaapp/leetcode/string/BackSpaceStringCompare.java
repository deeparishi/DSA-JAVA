package com.deeparishi.javaapp.leetcode.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/backspace-string-compare/description/

public class BackSpaceStringCompare {

    public static  boolean backspaceCompare(String s, String t) {

        List<Character> listA = new ArrayList<>();
        List<Character> listB = new ArrayList<>();

        for(char c : s.toCharArray()) {

            if (listA.isEmpty() && c != '#') {
                listA.add(c);
            }
            else if (c == '#' && !listA.isEmpty()) {
                listA.removeLast();
            } else if(c != '#') {
                listA.add(c);
            }
        }

        for(char c : t.toCharArray()) {

            if (listB.isEmpty() && c != '#' ) {
                listB.add(c);
            }
            else if (c == '#' && !listB.isEmpty()) {
                listB.removeLast();
            } else if(c != '#') {
                listB.add(c);
            }
        }

        if(listA.size() != listB.size())
            return false;

        return listA.equals(listB);

    }

    public static void main(String[] args) {

        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
