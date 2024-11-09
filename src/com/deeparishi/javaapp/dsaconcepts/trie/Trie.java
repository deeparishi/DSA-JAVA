package com.deeparishi.javaapp.dsaconcepts.trie;

import com.deeparishi.javaapp.dsaconcepts.trie.utls.Node;

public class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String words) {

        Node temp = root;

        for (int i = 0; i < words.length(); i++) {
            if (!temp.containsKey(words.charAt(i))) {
                temp.put(words.charAt(i), new Node());
            }
            temp = temp.get(words.charAt(i));
            temp.increasePrefix();
        }
        temp.increaseEnd();
        temp.setEnd();
    }

    public boolean search(String words) {

        Node temp = root;

        for (int i = 0; i < words.length(); i++) {
            if (!temp.containsKey(words.charAt(i)))
                return false;
            temp = temp.get(words.charAt(i));
        }

        return temp.isEnd();
    }

    public boolean startsWith(String words) {

        Node temp = root;

        for (int i = 0; i < words.length(); i++) {
            if (!temp.containsKey(words.charAt(i)))
                return false;
            temp = temp.get(words.charAt(i));
        }

        return true;
    }

    public int countWordsEqualTo(String word) {
        Node temp = root;

        for (int i = 0; i < word.length(); i++) {

            if (temp.containsKey(word.charAt(i)))
                temp = temp.get(word.charAt(i));
            else
                return -1;
        }

        return temp.getCntEndsWith();
    }

    public int countStartingWith(String words) {

        Node temp = root;

        for (int i = 0; i < words.length(); i++) {

            if (temp.containsKey(words.charAt(i)))
                temp = temp.get(words.charAt(i));
            else
                return -1;
        }

        return temp.getCountPrefix();
    }

    public void erase(String word) {

        Node temp = root;

        for (int i = 0; i < word.length(); i++) {

            if (temp.containsKey(word.charAt(i))) {
                temp = temp.get(word.charAt(i));
                temp.decreasePrefix();
            } else
                return;
        }

        temp.decreaseEnd();
    }

}
