package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.leetcode.trie.utl.Trie;

import java.util.List;

public class CompleteString {


    public static void main(String[] args) {

        List<String> words = List.of("abc", "bc", "ab", "qwe");
        System.out.println(completeString(6, words));
    }

    public static String completeString(int n, List<String> words){

        Trie trie = new Trie();

        for (String word : words)
            trie.insert(word);

        String longest = "";

        for (int i = 0; i < n; i++) {

            if (trie.checkIfPrefixExists(words.get(i))) {
                if (words.get(i).length() > longest.length())
                    longest = words.get(i);
                else if (words.get(i).length() == longest.length() && words.get(i).compareTo(longest) < 0)
                    longest = words.get(i);
            }
        }

        return longest;
    }

}
