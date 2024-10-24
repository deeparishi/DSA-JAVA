package com.deeparishi.javaapp.leetcode.stack;

import java.util.HashMap;
import java.util.Map;

public class UniqueString {

    public static void main(String[] args) {
        System.out.println(firstUniqueCharOptimized("aabb"));
    }

    static int firstUniqueChar(String s) {

            Map<Character, Integer> map = new HashMap<>();

            for (char c : s.toCharArray())  map.put(c, map.getOrDefault(c, 0) + 1);

            for (int i = 0; i < s.length(); i++) {
                int v = map.get(s.charAt(i));
                if (v == 1) return i;
            }
            return -1;
    }

    static int firstUniqueCharOptimized(String s) {

        char[] ch = new char[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ch[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(ch[c - 'a'] == 1) return i;
        }
        return -1;
    }
}
