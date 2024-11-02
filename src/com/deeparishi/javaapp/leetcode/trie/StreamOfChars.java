package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.leetcode.trie.utl.Trie;
import com.deeparishi.javaapp.selfpractice.trie.utls.Node;

//https://leetcode.com/problems/stream-of-characters/submissions/?envType=problem-list-v2&envId=trie&difficulty=HARD


public class StreamOfChars {


    public static void main(String[] args) {
//        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
//
//        streamChecker.query('a'); // return False
//        streamChecker.query('b'); // return False
//        streamChecker.query('c'); // return False
//        streamChecker.query('d'); // return True, because 'cd' is in the wordlist
//        streamChecker.query('e'); // return False
//        streamChecker.query('f'); // return True, because 'f' is in the wordlist
//        streamChecker.query('g'); // return False
//        streamChecker.query('h'); // return False
//        streamChecker.query('i'); // return False
//        streamChecker.query('j'); // return False
//        streamChecker.query('k'); // return False
//        streamChecker.query('l'); // return True, because 'kl' is in the wordlist

        StreamChecker streamChecker = new StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});

        streamChecker.query('a'); // return False
        streamChecker.query('b'); // return False
        streamChecker.query('c'); // return False
        streamChecker.query('d'); // return True, because 'cd' is in the wordlist
        streamChecker.query('e'); // return False
        streamChecker.query('f'); // return True, because 'f' is in the wordlist
        streamChecker.query('g'); // return False
        streamChecker.query('h'); // return False
        streamChecker.query('i'); // return False
        streamChecker.query('j'); // return False
        streamChecker.query('k'); // return False
        streamChecker.query('l'); // return True, because 'kl' is in the wordlist

    }

}

class StreamChecker {

    Trie trie = new Trie();

    public StreamChecker(String[] words) {
        for (String word : words){
            trie.insert(new StringBuilder(word).reverse().toString());
        }
    }

    public boolean query(char letter) {

        return trie.query(letter);

    }
}