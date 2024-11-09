package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.dsaconcepts.trie.utls.Node;

public class CountDistinctSubstring {

    public static void main(String[] args) {

        System.out.println(countDistinctSubString("abab"));
    }

    static int countDistinctSubString(String s){

        int cnt = 1;
        Node root = new Node();

        for (int i = 0; i < s.length(); i++) {
            Node node = root;

            for (int j = i; j < s.length(); j++) {
                if(!node.containsKey(s.charAt(j))){
                    cnt++;
                    node.put(s.charAt(j), new Node());
                }
                node = node.get(s.charAt(j));
            }
        }

        return cnt;


    }
}
