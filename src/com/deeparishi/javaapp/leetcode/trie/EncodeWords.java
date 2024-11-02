package com.deeparishi.javaapp.leetcode.trie;

//https://leetcode.com/problems/short-encoding-of-words/description/?envType=problem-list-v2&envId=trie&difficulty=MEDIUM

import java.util.*;

public class EncodeWords {

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    static int minimumLengthEncoding(String[] words) {

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        for (String word : words){
            for (int i = 1; i < word.length(); i++) {
                uniqueWords.remove(word.substring(i));
            }
        }

        int len = 0;

        for (String word : uniqueWords)
            len += word.length() + 1;

        return len;
    }
}
