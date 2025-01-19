package com.deeparishi.javaapp.leetcode.string;

import java.util.*;

// https://leetcode.com/problems/string-matching-in-an-array/

public class StringMatchingInArray {

    public static void main(String[] args) {

        String[] words = new String[] {"leetcode","et","code"};
        System.out.println(stringMatchingV3(words));
    }

    public static List<String> stringMatching(String[] words) {

        Set<String> res = new HashSet<>();
        for (String word : words) {
            for (String comparingWord : words) {
                if (!Objects.equals(word, comparingWord)) {
                    if (word.contains(comparingWord))
                        res.add(comparingWord);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static List<String> stringMatchingV2(String[] words) {

        Set<String> res = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if(isSubStringExists(words, curr, i)) res.add(curr);
        }
        return new ArrayList<>(res);
    }

    private static boolean isSubStringExists(String[] words, String curr, int idxToExclude) {

        for (int i = 0; i < words.length; i++) {
            if (i == idxToExclude) continue;
            if (words[i].contains(curr)) return true;
        }
        return false;
    }

    public static List<String> stringMatchingV3(String[] words) {
        String str = String.join(" ", words);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (str.indexOf(word) != str.lastIndexOf(word))
                res.add(word);
        }
        return res;
    }
}
