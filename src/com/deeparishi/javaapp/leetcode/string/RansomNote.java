package com.deeparishi.javaapp.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {

    public static void main(String[] args) {

    }
    public boolean canConstruct(String ransomNote, String magazine) {

        List<Character> charList = new ArrayList<>(magazine.chars()
                .mapToObj(c -> (char) c)
                .toList());

        boolean flag = false;

        for (Character ch : ransomNote.toCharArray()){
            if(charList.contains(ch))
                charList.remove(ch);
            else
                flag = false;
        }

//        return flag;

            char[] ch = new char[26];

           for (char a : magazine.toCharArray()){
               ch[a - 'a']++;
           }

           for(char a : ransomNote.toCharArray()){
               if(ch[a - 'a'] == 0) return false;
               ch[a - 'a']--;
           }

           return true;
    }
}
