package com.deeparishi.javaapp.leetcode.subsequence;

import java.util.*;

// https://leetcode.com/problems/number-of-matching-subsequences/

public class NoOfMatchingSubSequences {

    public static void main(String[] args) {
        String str = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubsequencesV2(str, words));
    }

    // create lookup for a string and then do the validation of words with lookup indices instead of
    // linear search do the binary search
    public static int numMatchingSubsequencesV3(String s, String[] words) {

        Map<Character, List<Integer>> lookup = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            lookup.computeIfAbsent(s.charAt(i),
                            _ -> new ArrayList<>())
                    .add(i);


        int count = 0;

        for (String word : words) {
            int curr = -1;
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (!lookup.containsKey(ch))
                    break;
                int idx = getLatestIdxViaBinarySearch(curr, lookup.get(ch));
                if (idx == -1) break;
                curr = idx;
                if (j == word.length() - 1) count++;
            }
        }

        return count;
    }

    public static int getLatestIdxViaBinarySearch(int curr, List<Integer> indices) {
        int idx = -1;
        int left = 0;
        int right = indices.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (indices.get(mid) > curr) {
                idx = indices.get(mid);
                right = mid - 1;
            } else
                left = mid + 1;

        }

        return idx;
    }


    // create lookup for a string and then do the validation of words with lookup indices
    public static int numMatchingSubsequencesV2(String s, String[] words) {

        Map<Character, List<Integer>> lookup = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (lookup.containsKey(ch))
                lookup.get(ch).add(i);
            else {
                List<Integer> idx = new ArrayList<>();
                idx.add(i);
                lookup.put(ch, idx);
            }
        }


        int count = 0;

        for (String word : words) {
            int curr = -1;
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (!lookup.containsKey(ch))
                    break;
                int idx = getLatestIdx(ch, curr, lookup);
                if (idx == -1) break;
                curr = idx;
                if (j == word.length() - 1) count++;
            }
        }

        return count;
    }

    private static int getLatestIdx(char ch, int curr, Map<Character, List<Integer>> lookup) {

        List<Integer> indices = lookup.get(ch);

        for (int i : indices) {
            if (i > curr)
                return i;
        }

        return -1;
    }

    // Generate all the possible subsequences and check that then increase the count
    public int numMatchingSubsequencesV1(String s, String[] words) {
        Set<String> subsequences = new HashSet<>();
        generateSeq(s, 0, "", subsequences);
        int count = 0;

        for (String word : words) {
            if (subsequences.contains(word))
                count++;
        }

        return count;
    }

    public static void generateSeq(String word, int index, String curr, Set<String> subsequences) {
        if (index == word.length()) {
            subsequences.add(curr);
            return;
        }

        generateSeq(word, index + 1, curr + word.charAt(index), subsequences);
        generateSeq(word, index + 1, curr, subsequences);
    }

}