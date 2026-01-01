package com.deeparishi.javaapp.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefixV2(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefixV2(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefixV2(new String[]{"interspacecraft", "interstellar", "internet"}));
        System.out.println(longestCommonPrefixV2(new String[]{"", "abc", "abcd"}));
        System.out.println(longestCommonPrefixV2(new String[]{"test", "test", "test"}));
        System.out.println(longestCommonPrefixV2(new String[]{"test", "testing", "tester"}));
    }

    public static String longestCommonPrefixV1(String[] words) {

        if (words.length == 1) return words[0];

        Arrays.sort(words);
        int firstLen = words[0].length();
        int lastLen = words[words.length - 1].length();

        int x = 0;
        int y = 0;
        StringBuilder str = new StringBuilder();

        while (x < firstLen && y < lastLen) {
            if (words[0].charAt(x) == words[words.length - 1].charAt(y)) {
                str.append(words[0].charAt(x));
                x++;
                y++;
            } else break;
        }

        return str.toString();
    }

    public static String longestCommonPrefixV2(String[] words) {
        if (words == null || words.length == 0) return "";
        if (words.length == 1) return words[0];

        Trie trie = new Trie();

        for (String word : words) {
            if (word.isEmpty()) return "";
            trie.insert(word);
        }

        return trie.findLongestCommonPrefix();
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
            }
            current.isEndOfWord = true;
        }

        String findLongestCommonPrefix() {
            StringBuilder prefix = new StringBuilder();
            TrieNode current = root;

            while (current != null &&
                    current.children.size() == 1 &&
                    !current.isEndOfWord) {
                Map.Entry<Character, TrieNode> entry = current.children.entrySet().iterator().next();
                prefix.append(entry.getKey());
                current = entry.getValue();
            }

            return prefix.toString();
        }
    }
}