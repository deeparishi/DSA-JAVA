package com.deeparishi.javaapp.leetcode.hashing;

import java.util.HashSet;
import java.util.Set;

public class BinaryCodes {

    public static void main(String[] args) {

        System.out.println(hasAllCodes("00110110", 2));
        System.out.println(hasAllCodes("0110", 1));
        System.out.println(hasAllCodes("0110", 2));

        System.out.println(1 << 35);
    }

    static boolean hasAllCodes(String s, int k) {

            int totalCodes = 1  << k; // equivalent to 2^k
        Set<String> foundCodes = new HashSet<>();

        // Step 2: Use a sliding window to extract each substring of length k
        for (int i = 0; i <= s.length() - k; i++) {
            String code = s.substring(i, i + k);

            // Step 3: Add the code to the set if it's unique
            if (!foundCodes.contains(code)) {
                foundCodes.add(code);
                totalCodes--;

                // Step 4: Early exit if we've found all possible codes
                if (totalCodes == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
