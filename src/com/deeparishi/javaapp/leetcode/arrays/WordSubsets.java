package com.deeparishi.javaapp.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-subsets/submissions/1503647450/?envType=daily-question&envId=2025-01-10

public class WordSubsets {

    public static void main(String[] args) {

        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};

        System.out.println(wordSubsets(words1, words2));

        String[] words3 = {"amazon","apple","facebook","google","leetcode"};
        String[] words4 = {"l","e"};

        System.out.println(wordSubsets(words3, words4));


        String[] words5 = {"amazon","apple","facebook","google","leetcode"};
        String[] words6 = {"lo","eo"};

        System.out.println(wordSubsets(words5, words6)); // "google","leetcode"

        String a = "amazon";

    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> res = new ArrayList<>();
        int[] maxFreq = new int[26];

        for (String word : words2) {
            int[] freq = generateFreqForWord(word);
            for (int i = 0; i < 26; i++)
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
        }

        for (String word : words1) {
            int[] freq = generateFreqForWord(word);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(word);
        }

        return res;
    }

    private static int[] generateFreqForWord(String word) {

        int[] freq = new int[26];

        for (char ch : word.toCharArray())
            freq[ch - 'a']++;

        return freq;
    }
}
