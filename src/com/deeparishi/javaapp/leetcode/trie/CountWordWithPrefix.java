package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.leetcode.trie.utl.Trie;

public class CountWordWithPrefix {

    public static void main(String[] args) {
        String[] words1 = {"pay","attention","practice","attend"};
        System.out.println(prefixCount(words1, "at"));
    }

    public static int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        int count = 0;
        for (String word : words)
            trie.insert(word);
        for (String word : words) {
            if(trie.checkIfPrefixExists(word))
                count++;
        }

        return count;
    }
}

