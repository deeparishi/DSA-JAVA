package com.deeparishi.javaapp.leetcode.hashing;

import java.util.ArrayList;
import java.util.List;

public class BeautifulIndices {

    public static void main(String[] args) {
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 15;

        List<Integer> result = beautifulIndices(s, a, b, k);
        System.out.println(result); // Output: [0, 3]
    }

    static List<Integer> findBeautifulIndices(String s, String a, String b, int k) {

        List<Integer> beautifulIndices = new ArrayList<>();
        int aLength = a.length();
        int bLength = b.length();
        int sLength = s.length();

        // Step 1: Find all indices of substring a
        List<Integer> indicesA = new ArrayList<>();
        for (int i = 0; i <= sLength - aLength; i++) {
            if (s.substring(i, i + aLength).equals(a)) {
                indicesA.add(i);
            }
        }

        // Step 2: Find all indices of substring b
        List<Integer> indicesB = new ArrayList<>();
        for (int j = 0; j <= sLength - bLength; j++) {
            if (s.substring(j, j + bLength).equals(b)) {
                indicesB.add(j);
            }
        }

        // Step 3: Check proximity condition and add beautiful indices
        for (int i : indicesA) {
            for (int j : indicesB) {
                if (Math.abs(j - i) <= k) {
                    beautifulIndices.add(i);
                    break; // No need to check other j's if we found one valid j
                }
            }
        }

        return beautifulIndices;
    }


    static List<Integer> beautifulIndices(String s, String a, String b, int k) {

        int aLen = a.length();
        int bLen = b.length();
        int sLen = s.length();
        List<Integer> beautifulIndices = new ArrayList<>();

        List<Integer> aIndex = getBeautifulIndices(s, a, aLen, sLen);
        List<Integer> bIndex = getBeautifulIndices(s, b, bLen, sLen);

        for (Integer i : aIndex) {
            for (Integer j : bIndex) {
                if (j - i <= k) {
                    beautifulIndices.add(i);
                    break;
                }
            }
        }

        return beautifulIndices;

    }

    static List<Integer> getBeautifulIndices(String s, String a, int aLen, int sLen) {

        List<Integer> beautifulIndices = new ArrayList<>();

        for (int i = 0; i <= sLen - aLen; i++) {
            String d = s.substring(i, i + aLen);
            if (d.equals(a)) {
                beautifulIndices.add(i);
            }
        }
        return beautifulIndices;
    }
}
