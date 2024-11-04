package com.deeparishi.javaapp.leetcode.slidingwindow;

import java.util.*;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=problem-list-v2&envId=sliding-window

public class ContentedPermutation {

    public static void main(String[] args) {

//        System.out.println(findSubstringOptimized("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        System.out.println(findSubstringOptimized("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }

    static List<Integer> findSubstringOptimized(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;

        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordMap.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    static List<Integer> findSubstring(String s, String[] words) {

        Set<String> possibleWords = generateAllConcatenations(words);
        int a = s.length();
        int b = possibleWords.iterator().next().length();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= a - b; i++){
            String str = s.substring(i, i + b);
            if(possibleWords.contains(str))
                result.add(i);
        }

        return result;
    }
    public static Set<String> generateAllConcatenations(String[] words) {
        Set<String> result = new HashSet<>();
        permute(words, 0, result);
        return result;
    }

    private static void permute(String[] words, int start, Set<String> result) {
        if (start == words.length) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word);
            }
            result.add(sb.toString());
        } else {
            for (int i = start; i < words.length; i++) {
                swap(words, start, i);
                permute(words, start + 1, result);
                swap(words, start, i);
            }
        }
    }

    private static void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
