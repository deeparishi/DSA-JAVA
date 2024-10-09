package com.deeparishi.javaapp.old.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanTOInteger {

        public static void main(String[] args) {
            System.out.println(romanToInt("MCMXIV"));
        }

        public static int romanToInt(String s) {
            Map<Character, Integer> values = new HashMap<>();
            values.put('I', 1);
            values.put('V', 5);
            values.put('X', 10);
            values.put('L', 50);
            values.put('C', 100);
            values.put('D', 500);
            values.put('M', 1000);

            int sum = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i + 1 < s.length() && values.get(s.charAt(i + 1)) > values.get(c)) {
                    sum += values.get(s.charAt(i + 1)) - values.get(c);
                    i += 1;
                } else {
                    sum += values.get(c);
                }
            }

            return sum;
        }
    }

