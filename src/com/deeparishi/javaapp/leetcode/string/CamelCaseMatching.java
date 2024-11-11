package com.deeparishi.javaapp.leetcode.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/camelcase-matching/submissions/1443496026/?envType=problem-list-v2&envId=trie

public class CamelCaseMatching {

    public static void main(String[] args) {
            System.out.println(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB"));
            System.out.println(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa"));
        System.out.println(camelMatch(new String[]{"FooTestBar","FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT"));
    }
    static List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> passed = new ArrayList<>();

        for(String word : queries) {
            if(isValidPatter(word, pattern)){
                passed.add(true);
            }else
                passed.add(false);
        }

        return passed;
    }

    static boolean isValidPatter(String word, String pattern) {
        int pIdx = 0; // pointer for the pattern
        int qIdx = 0; // pointer for the query

        while (qIdx < word.length()) {
            char qChar = word.charAt(qIdx);

            // Check if current character in query matches the current character in pattern
            if (pIdx < pattern.length() && qChar == pattern.charAt(pIdx)) {
                pIdx++; // Move to the next character in pattern
            } else if (Character.isUpperCase(qChar)) {
                // If it's an uppercase letter in query that doesn't match pattern, return false
                return false;
            }

            qIdx++; // Move to the next character in query
        }

        // Check if we've matched the entire pattern
        return pIdx == pattern.length();
    }
}



