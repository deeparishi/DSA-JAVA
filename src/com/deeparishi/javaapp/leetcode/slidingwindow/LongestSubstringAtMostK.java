package com.deeparishi.javaapp.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostK {

    public static void main(String[] args) {

        System.out.println(lengthOfSubstringV2("aaabbccd", 2));
        System.out.println();
    }

    //Better Approach
    public static int lengthOfSubstringV2(String s, int k) {

        int len = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {

            char rCh = s.charAt(right);
            map.put(rCh, map.getOrDefault(rCh, 0) + 1);

            while (map.size() > k) {
                char lCh = s.charAt(left);
                map.put(lCh, map.getOrDefault(lCh, 0) - 1);
                if (map.get(lCh) == 0) map.remove(lCh);
                left++;
            }

            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;
    }

        // Brute Force Approach
    public static int lengthOfSubstring(String s, int k) {

        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() <= k)
                    len = Math.max(len, j - i + 1);
                else break;
            }
        }

        return len;
    }
}
