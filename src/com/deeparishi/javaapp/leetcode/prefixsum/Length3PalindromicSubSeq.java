package com.deeparishi.javaapp.leetcode.prefixsum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Length3PalindromicSubSeq {

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequenceV3("bbcbaba"));
    }

    // 56 MS
    public int countPalindromicSubsequenceV2(String s) {

        if (s.length() < 3) return 0;

        Map<Character, Integer> firstOccurrence = new HashMap<>();
        Map<Character, Integer> lastOccurrence = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            firstOccurrence.putIfAbsent(c, i);
            lastOccurrence.put(c, i);
        }

        int count = 0;

        for (Map.Entry<Character, Integer> entry : firstOccurrence.entrySet()) {

            char middleChar = entry.getKey();
            int start = firstOccurrence.get(middleChar);
            int end = lastOccurrence.get(middleChar);

            if (end - start < 2) {
                continue;
            }

            boolean[] seen = new boolean[26];
            for (int i = start + 1; i < end; i++) {
                seen[s.charAt(i) - 'a'] = true;
            }

            for (boolean isSeen : seen)
                if (isSeen) count++;

        }

        return count;
    }

    // 84 MS
    public static int countPalindromicSubsequenceV3(String s) {

        Pair[] arr = new Pair[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = new Pair(-1, -1);
        }

        for (int i = 0; i < s.length(); i++) {
            Pair pair = arr[s.charAt(i) - 'a'];
            if (pair.firstOcc == -1) pair.firstOcc = i;
            else pair.secondOcc = i;
        }

        int cnt = 0;

        for (Pair pair : arr) {
            if (pair.firstOcc != -1 && pair.secondOcc != -1) {
                HashSet<Character> hs = new HashSet<>();
                for (int j = pair.firstOcc + 1; j < pair.secondOcc; j++)
                    hs.add(s.charAt(j));
                cnt += hs.size();
            }
        }

        return cnt;
    }

}

class Pair {
    int firstOcc;
    int secondOcc;

    Pair(int firstOcc, int secondOcc) {
        this.firstOcc = firstOcc;
        this.secondOcc = secondOcc;
    }
}