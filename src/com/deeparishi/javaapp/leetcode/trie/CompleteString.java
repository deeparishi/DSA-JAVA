package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.selfpractice.trie.utls.Node;

import java.util.List;

public class CompleteString {


    public static void main(String[] args) {

        List<String> words = List.of("n", "ninja", "ninj","ni", "nin","ninga");
        System.out.println(completeString(6, words));
    }

    public static String completeString(int n, List<String> words){

        Trie trie = new Trie();

        for (String word : words)
            trie.insert(word);

        String longest = "";

        for (int i = 0; i < n; i++) {

            if (trie.checkIfPrefixExists(words.get(i))){
                if (words.get(i).length() > longest.length())
                    longest = words.get(i);
                else if (words.get(i).length() == longest.length() &&
                            words.get(i).compareTo(longest) < 0)
                    longest = words.get(i);
            }
        }

        return longest;
    }

}

class Trie{

     Node root;

    public Trie(){
        root = new Node();
    }

    public  void insert(String words){
        Node temp = root;
        for (int i = 0; i < words.length(); i++) {

            if(!temp.containsKey(words.charAt(i))){
                temp.put(words.charAt(i), new Node());
            }
            temp = temp.get(words.charAt(i));
        }
        temp.setEnd();
    }


    public boolean checkIfPrefixExists(String word) {

        Node temp = root;
        boolean flag = true;

        for (int i = 0; i < word.length(); i++) {
            if (temp.containsKey(word.charAt(i))){
                temp = temp.get(word.charAt(i));
                flag = flag && temp.isEnd();
            }
            else return false;
        }

        return flag;

    }
}
