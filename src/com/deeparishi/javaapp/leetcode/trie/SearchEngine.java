package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.leetcode.trie.utl.Trie;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/description/?envType=problem-list-v2&envId=trie&difficulty=MEDIUM

public class SearchEngine {


    public static void main(String[] args) {

        System.out.println(suggestedProducts(new String[]
                {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie trie = new Trie();

        for (String product : products)
            trie.insertForSearchEngine(product);

        StringBuilder builder = new StringBuilder();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            builder.append(searchWord.charAt(i));
            result.add(trie.searchWord(builder.toString()));
        }

        return result;
    }

}




