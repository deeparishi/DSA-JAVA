package com.deeparishi.javaapp.leetcode.greedyalgo;

// https://leetcode.com/problems/remove-duplicate-letters/?envType=problem-list-v2&envId=greedy

public class RemoveDuplicateLetter {

    public static void main(String[] args) {

        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public static String removeDuplicateLetters(String s) {

        int[] charIdx = new int[26];

        for (char ch : s.toCharArray()) {
            int idx = s.lastIndexOf(ch);
            charIdx[ch - 'a'] = idx;
        }

        boolean[] seen = new boolean[26];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (seen[ch - 'a']) continue;

            while (!builder.isEmpty() && builder.charAt(builder.length() - 1) > ch
                    && charIdx[builder.charAt(builder.length() - 1) - 'a'] > i) {
                seen[builder.charAt(builder.length() - 1) - 'a'] = false;
                builder.deleteCharAt(builder.length() - 1);
            }

            builder.append(ch);
            seen[ch - 'a'] = true;
        }

        return builder.toString();
    }
}
