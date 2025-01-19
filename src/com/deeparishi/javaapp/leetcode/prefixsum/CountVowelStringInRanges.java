package com.deeparishi.javaapp.leetcode.prefixsum;

import java.util.*;

// https://leetcode.com/problems/count-vowel-strings-in-ranges

public class CountVowelStringInRanges {

    public static void main(String[] args) {
        String[] words = new String[]{"aba","bcb","ece","aa","e"};
        int[][] queries = new int[][]{
                {0, 2},
                {1, 4},
                {1, 1}
        };

        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {

        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Integer> repeated = new ArrayList<>();

        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (Character ch : word.toCharArray()) {
                if (vowels.contains(ch)) set.add(ch);
            }
            repeated.add(set.size());
        }

        int[] res = new int[queries.length];
        int i = 0;

        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];
            int result = 0;
            for (int j = x; j <= y; j++) {
                result += repeated.get(j);
            }
            res[i] = result;
            i++;
        }

        return res;
    }

    public int[] vowelStrings2(String[] words, int[][] queries) {

        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        int[] isVowelString = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty() && vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1)))
                isVowelString[i] = 1;
        }

        int[] prefixSum = new int[words.length + 1];
        int[] res = new int[queries.length];

        for (int i = 0; i < words.length; i++)
            prefixSum[i + 1] = prefixSum[i] + isVowelString[i];


        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = prefixSum[r + 1] - prefixSum[l];
        }

        return res;
    }
}
