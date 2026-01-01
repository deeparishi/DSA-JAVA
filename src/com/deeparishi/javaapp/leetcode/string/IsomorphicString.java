package com.deeparishi.javaapp.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphicV3("egg", "add"));
        System.out.println(isIsomorphicV3("foo", "bar"));
        System.out.println(isIsomorphicV3("paper", "title"));
        System.out.println(isIsomorphicV3("badc", "baba"));
        System.out.println(isIsomorphicV3("13", "42"));
    }

    // Optimal + More Readable code!
    public static boolean isIsomorphicV3(String s, String t) {

        if (s.length() != t.length())
            return false;
        if (s.equals(t))
            return true;

        char[] ST = new char[127];
        char[] TS = new char[127];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (ST[a] == 0 && TS[b] == 0) {
                ST[a] = b;
                TS[b] = a;
            } else {
                if (ST[a] != b || TS[b] != a) return false;
            }
        }
        return true;
    }

    // Optimal approach
    public static boolean isIsomorphicV2(String s, String t) {

        if (s.length() != t.length()) return false;
        char[] ST = new char[127];
        char[] TS = new char[127];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            int x = a - 'a';
            int y = b - 'a';

            if (ST[x] != '\u0000' && ST[x] != b)
                return false;
            else
                ST[x] = b;


            if (TS[y] != '\u0000' && TS[y] != a)
                return false;
            else
                TS[y] = a;
        }

        return true;
    }

    // Brute force approach
    public boolean isIsomorphicV1(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> ST = new HashMap<>();
        Map<Character, Character> TS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (ST.containsKey(a) && ST.get(a) != b)
                return false;
            else
                ST.put(a, b);

            if (TS.containsKey(b) && TS.get(b) != a)
                return false;
            else
                TS.put(b, a);
        }

        return true;
    }

}
