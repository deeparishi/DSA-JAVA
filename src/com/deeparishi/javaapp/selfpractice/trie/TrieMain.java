package com.deeparishi.javaapp.selfpractice.trie;

public class TrieMain {

    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("apple");
//        trie.insert("apps");
//        trie.insert("apxl");
//        trie.insert("apd");
//        trie.insert("bat");
//        trie.insert("bar");
//        trie.insert("bac");
//        trie.insert("abcde");

        trie.insert("samsung");
        trie.insert("samsung");
        trie.insert("vivo");
        trie.insert("apple");
        trie.insert("vivo");
        trie.insert("vivo");
        trie.insert("apple");
        trie.insert("iphone");
        trie.insert("element");
        trie.insert("appdd");
        trie.insert("appxx");
        trie.insert("appxkl");

        System.out.println(trie.countWordsEqualTo("samsung"));
        System.out.println(trie.countWordsEqualTo("vivo"));
        System.out.println(trie.countStartingWith("app"));
        System.out.println(trie.countWordsEqualTo("vivo"));
        trie.erase("samsung");
        System.out.println("After samsung erase "+trie.countWordsEqualTo("samsung"));
    }
}
