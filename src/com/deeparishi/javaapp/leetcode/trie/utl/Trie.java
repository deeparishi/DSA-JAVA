package com.deeparishi.javaapp.leetcode.trie.utl;

import com.deeparishi.javaapp.dsaconcepts.trie.utls.Node;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }


    public void insert(String word) {

        Node temp = root;

        for (int i = 0; i < word.length(); i++) {
            if (!temp.containsKey(word.charAt(i))) {
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
        }

        temp.setEnd();
    }

    public boolean isValid(String word) {

        Node temp = root;

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            temp = temp.get(c);

            if (temp == null || (i < word.length() - 1 && !temp.isEnd()))
                return false;
        }

        return true;
    }

    public boolean checkIfPrefixExists(String word) {

        Node temp = root;
        boolean flag = true;

        for (int i = 0; i < word.length(); i++) {
            if (temp.containsKey(word.charAt(i))) {
                temp = temp.get(word.charAt(i));
                flag = flag && temp.isEnd();
            } else return false;
        }

        return flag;

    }

    public void insertForSearchEngine(String word){

        Node temp = root;

        for (int i = 0; i < word.length(); i++) {
            if(!temp.containsKey(word.charAt(i))){
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
            temp.addSuggestion(word);
        }

        temp.setEnd();
    }

    public List<String> searchWord(String word){

        Node temp = root;

        for (int i = 0; i < word.length(); i++) {

            if(!temp.containsKey(word.charAt(i)))
                return new ArrayList<>();

            temp = temp.get(word.charAt(i));
        }

        return temp.getSuggestions();
    }

    public void insert(String word, int index){

        Node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!temp.containsKey(ch)){
                temp.put(ch, new Node());
                temp.index.add(index);
            }
            temp = temp.get(ch);
        }

        temp.setEnd();
    }

    public List<Integer> startsWith(String word){

        Node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!temp.containsKey(ch))
                return new ArrayList<>();
            temp = temp.get(ch);
        }

        return temp.index;
    }


    public boolean query(StringBuilder letter) {

        Node temp = root;
        String l = letter.toString();

        for(int i = letter.length()-1; i >= 0; i--){
            char ch = letter.charAt(i);
            if(!temp.containsKey(ch)) return false;
            temp = temp.get(ch);
            if(temp.isEnd()) return true;
        }

        return false;
    }

    public boolean canBeBuilt(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.get(ch);
            if (node == null || !node.isEnd()) {
                return false;
            }
        }
        return true;
    }
}