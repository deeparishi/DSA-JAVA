package com.deeparishi.javaapp.leetcode.slidingwindow;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters

public class SubstringContainAllThreeChar {

    public static void main(String[] args) {

        System.out.println(numberOfSubstringsV3("abcabc"));
        System.out.println(numberOfSubstringsV3("aaacb"));
        System.out.println(numberOfSubstringsV3("abc"));
    }

    public int numberOfSubstringsV4(String s) {
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            lastSeen[ch - 'a'] = right;
            int min = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            if (min != -1) count += min + 1;
        }
        return count;
    }

    public static int numberOfSubstringsV3(String s) {

        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastSeen[ch - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));

            }
        }

        return count;
    }

    public static int numberOfSubstringsV2(String s) {

        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[3];
            for (int j = i; j < s.length(); j++) {
                hash[s.charAt(j) - 'a']++;
                if (hash[0] + hash[1] + hash[2] == 3) {
                    len += s.length() - j;
                    break;
                }
            }
        }

        return len;
    }

    public static int numberOfSubstringsV1(String s) {

        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String newStr = s.substring(i, j + 1);
                if (newStr.contains("a") && newStr.contains("b") && newStr.contains("c")) {
                    len++;
                }
            }
        }

        return len;
    }
}