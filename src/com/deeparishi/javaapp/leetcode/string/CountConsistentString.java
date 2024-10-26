package com.deeparishi.javaapp.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class CountConsistentString {

    public static void main(String[] args) {

        String [] arr = new String[]{"ad","bd","aaab","baa","badab"};
        int ans = countConsistentStrings("ab", arr);
        System.out.println(ans);
    }
    public static int countConsistentStrings(String allowed, String[] words) {

        List<Character> allowedChars = new ArrayList<>();
        int count  =0 ;

        for (int i = 0; i < allowed.length(); i++) {
            char v = allowed.charAt(i);
            allowedChars.add(v);
        }

        for (String word : words){
            int flag = 1;
            for (int i = 0; i < word.length(); i++) {
                if(!allowedChars.contains(word.charAt(i))){
                    flag = 0;
                    break;
                }
            }
            count+=flag;
        }

        return count;
    }

    public static int countConsistentStringsNew(String allowed, String[] words) {

        List<Character> allowedChars = new ArrayList<>();
        int count  =0 ;

        for (char c : allowed.toCharArray()) {
            allowedChars.add(c);
        }

        for (String word : words){
            int flag = 1;
            for (char c : word.toCharArray()) {
                if(!allowedChars.contains(c)){
                    flag = 0;
                    break;
                }
            }
            count+=flag;
        }

        return count;
    }
}
