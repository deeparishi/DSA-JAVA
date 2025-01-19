package com.deeparishi.javaapp.leetcode.prefixsum;

// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/?envType=daily-question&envId=2025-01-08

public class CountPrefixAndSuffixPairsI {

    public static void main(String[] args) {

        String[] word1 = new String[]{"a", "aba", "ababa", "aa"};
        String[] word2 = new String[]{"pa", "papa", "ma", "mama"};
        String[] word3 = new String[]{"abab", "ab"};

        System.out.println(countPrefixSuffixPairsV2(word1));
        System.out.println(countPrefixSuffixPairsV2(word2));
        System.out.println(countPrefixSuffixPairsV2(word3));

    }

    public static int countPrefixSuffixPairs(String[] words) {

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                String a = words[i];
                String b = words[j];
                if(b.startsWith(a) && b.endsWith(a)) count++;
            }
        }

        return count;

    }

    public static int countPrefixSuffixPairsV2(String[] words) {

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String a = words[i];
                String b = words[j];
                if(isPrefixAndSuffix(a, b)) count++;
            }
        }

        return count;
    }

    private static boolean isPrefixAndSuffix(String a, String b) {

        int len1 = a.length();
        int len2 = b.length();

        boolean prefix = len1 <= len2 && b.substring(0, len1).equals(a);
        boolean suffix = len1 <= len2 && b.substring(len2 - len1).equals(a);

        return prefix && suffix;
    }
}