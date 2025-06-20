package com.deeparishi.javaapp.leetcode.slidingwindow;

// https://leetcode.com/problems/longest-substring-without-repeating-characters

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringV2("abcabcbb"));
        System.out.println(lengthOfLongestSubstringV2("bbbbb"));
        System.out.println(lengthOfLongestSubstringV2("pwwkew"));
    }

    // Optimal Approach
    public static int lengthOfLongestSubstringV2(String s) {

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while (right < s.length()) {
            int ch = s.charAt(right);
            if (hash[ch] != -1) { // Check If that ch is already found or not
                // If the character is found, its index should either be the current or upcoming
                // character and should not belong to a past index.
                if (hash[ch] >= left)
                    left = hash[ch] + 1; // then left should be jumped from that already present idx
            }

            int len = right - left + 1; // To find the currLen
            maxLen = Math.max(maxLen, len); // get max Len
            hash[ch] = right; // update the ch with currIdx
            right++; // Move the right one
        }

        return maxLen;
    }

    // Brute Force Approach
    public static int lengthOfLongestSubstringV1(String s) {

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean[] hash = new boolean[256];
            int currLen = 0;
            for (int j = i; j < s.length(); j++) {
                int ch = s.charAt(j);
                if (!hash[ch]) {
                    hash[ch] = true;
                    currLen++;
//                    int currLen = j - i + 1;
                    maxLen = Math.max(currLen, maxLen);
                } else
                    break;
            }
        }

        return maxLen;
    }
}