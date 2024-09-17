package com.deeparishi.javaapp.leetcode;

import java.util.HashMap;


//https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts

public class LongestSubstringWithEvenVowels {

    public static int findTheLongestSubstring(String s) {
        // Step 1: Initialize a hashmap to track the bitmask and its first occurrence index
        HashMap<Integer, Integer> bitmaskMap = new HashMap<>();

        // Step 2: Initialize bitmask and maxLength
        int bitmask = 0;
        int maxLength = 0;

        // Step 3: Add the initial bitmask of 0 (all vowels even) with index -1
        bitmaskMap.put(0, -1);  // This accounts for cases where the whole string up to index i has even vowels

        // Step 4: Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Step 5: Toggle the bit for each vowel encountered
            if (ch == 'a') {
                bitmask ^= (1 << 0);  // Toggle bit for 'a'
            } else if (ch == 'e') {
                bitmask ^= (1 << 1);  // Toggle bit for 'e'
            } else if (ch == 'i') {
                bitmask ^= (1 << 2);  // Toggle bit for 'i'
            } else if (ch == 'o') {
                bitmask ^= (1 << 3);  // Toggle bit for 'o'
            } else if (ch == 'u') {
                bitmask ^= (1 << 4);  // Toggle bit for 'u'
            }

            // Debugging Step: Print the current character and the bitmask in binary format
            System.out.printf("Index: %d, Char: %c, Bitmask: %05d\n", i, ch, Integer.parseInt(Integer.toBinaryString(bitmask)));

            // Step 6: Check if the bitmask has been seen before
            if (bitmaskMap.containsKey(bitmask)) {
                // Step 7: Calculate the length of the substring if bitmask was seen before
                int prevIndex = bitmaskMap.get(bitmask);
                int currentLength = i - prevIndex;

                // Debugging Step: Print the current substring length
                System.out.printf("Bitmask %05d seen before at index %d. Current length: %d\n", bitmask, prevIndex, currentLength);

                // Update maxLength
                maxLength = Math.max(maxLength, currentLength);

                // Debugging Step: Print the updated maxLength
                System.out.println(STR."Updated maxLength: \{maxLength}");

            } else {
                // Step 8: If bitmask not seen before, store the current index
                bitmaskMap.put(bitmask, i);

                // Debugging Step: Print the bitmask map's current state
                System.out.println(STR."New bitmask state stored. BitmaskMap: \{bitmaskMap}");
            }
        }

        // Step 9: Return the maximum length of the substring with even vowels
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";

        // Step 10: Run the function and print the result
        int result = findTheLongestSubstring(s);
        System.out.println(STR."The longest substring length with even vowels is: \{result}");
    }
}

