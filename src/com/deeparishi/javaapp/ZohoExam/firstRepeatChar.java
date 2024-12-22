package com.deeparishi.javaapp.ZohoExam;

import java.util.HashMap;

public class firstRepeatChar {
    public static void main(String[] args) {
        String s = "programming";

        System.out.println(firstRepeatedChar(s));


    }

    private static char firstRepeatedChar(String s) {
        HashMap<Character, Integer> a = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (a.containsKey(c)) {
                return c;
            } else {
                a.put(c, 1);
            }
        }
        return '\0';
    }

}
