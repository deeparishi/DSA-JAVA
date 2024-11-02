package com.deeparishi.javaapp.leetcode.trie;

import com.deeparishi.javaapp.leetcode.trie.utl.Trie;

import java.util.List;
import java.util.Objects;

//https://leetcode.com/problems/prefix-and-suffix-search/submissions/1440740243/?envType=problem-list-v2&envId=trie&difficulty=HARD

public class PrefixAndSuffixSearch {

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple", "applet", "ape"});
        System.out.println(wordFilter.f("a", "e"));

    }

}

class WordFilter{

    Trie prefix;

    Trie suffix;

    public WordFilter(String[] words){
        prefix = new Trie();
        suffix = new Trie();
        for (int i = 0; i < words.length; i++) {
            prefix.insert(words[i], i);
            suffix.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }

    public int f(String pref, String suff) {

        List<Integer> pList = prefix.startsWith(pref);
        List<Integer> sList = suffix.startsWith(new StringBuilder(suff).reverse().toString());

        int i = pList.size() - 1;
        int j = sList.size() - 1;

        while (i >= 0 && j >= 0){
            if(Objects.equals(pList.get(i), sList.get(j)))
                return pList.get(i);
            else if (pList.get(i) > sList.get(j))
                i--;
            else
                j--;
        }
        return -1;

    }
}
