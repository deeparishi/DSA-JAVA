package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.leetcode.trie.utl.Trie;

public class LongestWord {

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"w","wo","wor","worl","world"}));
        System.out.println(longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"}));
    }

    static String longestWord(String[] words) {

        Trie trie = new Trie();

        for (String s : words) {
            trie.insert(s);
        }

        String longest = "";
        for (String word : words) {
            if (trie.canBeBuilt(word)) {
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        return longest;

    }


}
