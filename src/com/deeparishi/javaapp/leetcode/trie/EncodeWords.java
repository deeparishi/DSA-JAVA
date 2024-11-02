package com.deeparishi.javaapp.leetcode.trie;

//https://leetcode.com/problems/short-encoding-of-words/description/?envType=problem-list-v2&envId=trie&difficulty=MEDIUM

import com.deeparishi.javaapp.selfpractice.trie.utls.Node;

import java.util.*;

public class EncodeWords {

    public static void main(String[] args) {
        System.out.println(minimumLengthEncodingUsingTrie(new String[]{"time", "me", "bell"}));
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

    static int minimumLengthEncodingUsingTrie(String[] words) {

        Node root = new Node();
        Map<Node, Integer> nodes = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        for (String word : uniqueWords) {
            Node temp = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (!temp.containsKey(word.charAt(i))) {
                    temp.put(word.charAt(i), new Node());
                }
                temp = temp.get(word.charAt(i));
            }
            nodes.put(temp, word.length());
        }

        int cnt = 0;

        for (Node node : nodes.keySet()) {
            if (node.isLeaf())
                cnt += nodes.get(node) + 1;
        }

        return cnt;
    }
}
