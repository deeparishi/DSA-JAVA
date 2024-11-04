package com.deeparishi.javaapp.leetcode.string;

import java.util.TreeMap;

// https://leetcode.com/problems/string-compression-iii/?envType=daily-question&envId=2024-11-04
public class CompressString {

    public static void main(String[] args) {

        System.out.println(compressedString("abcde"));  //1a1b1c1d1e
        System.out.println(compressedString("aaaaaaaaaaaaaabb")); //9a5a2b
    }

    static String compressedString(String word) {

        StringBuilder builder = new StringBuilder();
        int i = 0;

        while (i < word.length()){
            char ch = word.charAt(i);
            int count = 0;

            while (i < word.length() && word.charAt(i) == ch && count < 9){
                i++;
                count++;
            }

            builder.append(count).append(ch);
        }
        return builder.toString();
    }
}
