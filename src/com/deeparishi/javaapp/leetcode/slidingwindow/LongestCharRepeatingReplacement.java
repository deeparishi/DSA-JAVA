package com.deeparishi.javaapp.leetcode.slidingwindow;

// https://leetcode.com/problems/longest-repeating-character-replacement

public class LongestCharRepeatingReplacement {

    public static void main(String[] args) {

        System.out.println(characterReplacementV2("ABAB", 2));
        System.out.println(characterReplacementV2("AABABBA", 1));
        System.out.println(characterReplacementV2("ABBB", 2));
    }

    public static int characterReplacementV2(String s, int k) {

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxCount = 0;
        int[] count = new int[26];

        while (right < s.length()) {

            char currChar = s.charAt(right);
            count[currChar - 'A']++;

            maxCount = Math.max(maxCount, count[currChar - 'A']);

            if ((right - left + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static int characterReplacementV1(String s, int k) {

        int maxLen = 0;
        int trav = 0;

        for (char target = 'A'; target <= 'Z'; target++) {
            for (int i = 0; i < s.length(); i++) {
                int count = 0;
                int len = 0;
                trav++;
                for (int j = i; j < s.length(); j++) {

                    if (s.charAt(j) == target)
                        len++;

                    else if (count < k) {
                        len++;
                        count++;
                    } else
                        break;

                    maxLen = Math.max(maxLen, len);
                }
            }

            if(trav == s.length() - 1) break;;
        }

        return maxLen;
    }
}