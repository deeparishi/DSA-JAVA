package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.leetcode.trie.utl.Trie;

import java.util.*;

//https://github.com/EndaLin/leetcode-1/blob/main/solution/1800-1899/1858.Longest%20Word%20With%20All%20Prefixes/README_EN.md


class LongestWordWithPrefixes {

    public static void main(String[] args) {

        System.out.println(longestWordWthPrefix(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));

    }

    static String longestWordWthPrefix(String[] words){

        Trie trie = new Trie();

        List<String> wordsList = Arrays.asList(words);

        for (String word : wordsList)
            trie.insert(word);

        String longest = "";

        for (String word : wordsList){
            if(trie.isValid(word)){
                if(word.length() > longest.length() ||(word.length() == longest.length() && word.compareTo(longest) < 0)){
                    longest = word;
                }
            }
        }
        return longest;
    }

}