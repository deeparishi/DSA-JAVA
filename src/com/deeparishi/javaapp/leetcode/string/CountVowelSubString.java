package com.deeparishi.javaapp.leetcode.string;

import java.util.*;

// https://leetcode.com/problems/count-vowel-substrings-of-a-string/

public class CountVowelSubString {

    public static void main(String[] args) {
        System.out.println(countVowelSubstringsV2("aeiouu"));
    }

    public static int countVowelSubstringsV2(String word) {
        int count = 0;
        Map<Character, Integer> lastSeen =
                new HashMap<>(Map.of('a', -1, 'e', -1, 'i', -1, 'o', -1, 'u', -1));
        for (int i = 0, lastInvalidPos = -1; i < word.length(); i++) {
            if (lastSeen.containsKey(word.charAt(i))) {
                lastSeen.put(word.charAt(i), i);
                count += Math.max(Collections.min(lastSeen.values()) - lastInvalidPos, 0);
            } else {
                lastInvalidPos = i;
            }
        }
        return count;
    }

    public static int countVowelSubstrings(String word) {

        int len = word.length();
        int count = 0;

        for(int slow = 0; slow < len; slow++) {
            if(!isVowel(word.charAt(slow)))
                continue;
            Set<Character> seen = new HashSet<>();
            for(int fast = slow; fast < len; fast++) {
                char ch = word.charAt(fast);
                if (!isVowel(ch)) break;
                seen.add(ch);
                if (seen.size() == 5) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
