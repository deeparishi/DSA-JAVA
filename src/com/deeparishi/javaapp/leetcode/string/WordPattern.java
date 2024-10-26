package com.deeparishi.javaapp.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        boolean t = wordPattern("abba", "dog constructor constructo dog");
        System.out.println(t);
    }

//    Input: pattern = "abba", s = "dog cat cat dog"

    //"abba" "dog constructor constructo dog"

    public static boolean wordPattern(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        String[] sentence = s.split(" ");

        if (pattern.length() != sentence.length)
            return false;


        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = sentence[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(word))
                    return false;

            } else {
                if (usedWords.contains(word)) {
                    return false;
                }

                map.put(c, word);
                usedWords.add(word);

            }
        }

        return true;
    }
}
