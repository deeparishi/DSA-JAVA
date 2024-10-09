package com.deeparishi.javaapp.old.leetcode;

import java.util.List;
import java.util.stream.Collectors;

public class RansomNote {

    // https://leetcode.com/problems/ransom-note/description/?envType=problem-list-v2&envId=aw3pongc&difficulty=EASY

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {

        List<Character> charList = new java.util.ArrayList<>(magazine.chars()
                .mapToObj(c -> (char) c)
                .toList());

        boolean flag = true;

        for(Character c : ransomNote.toCharArray()){
            if (charList.contains(c)) {
                charList.remove(c);
            }else {
                flag = false;
            }
        }

        return flag;
    }
}
