package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.selfpractice.trie.Trie;
import com.deeparishi.javaapp.selfpractice.trie.utls.Node;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionaryClass wordDictionary = new WordDictionaryClass();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println( wordDictionary.search("bad"));
        System.out.println( wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
         // return False
        // return True
        // return True
         // return True
    }


}

class WordDictionaryClass {

    Node root;

    public WordDictionaryClass() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return searchInWord(word, root, 0);
    }

    private boolean searchInWord(String word, Node root, int index) {

        if(word.length() == index)
            return root.isEnd();

        char ch = word.charAt(index);

        if(ch == '.'){
            for (Node child : root.getAllChildren()){
                if(child != null && searchInWord(word, child, index+1)){
                    return true;
                }
            }
            return false;
        }
        else {
            if(root.containsKey(ch)){
                return searchInWord(word, root.get(ch), index+1);
            }
        }
        return false;
    }
}


